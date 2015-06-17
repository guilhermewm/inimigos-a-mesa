package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.dao.AlimentoDAO;
import br.com.aceleradora.inimigosamesa.dao.AlimentoRepository;
import br.com.aceleradora.inimigosamesa.dao.CategoriaDAO;
import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class AlimentoController {

    @Autowired
    AlimentoRepository repositorio;

    @Autowired
    AlimentoDAO alimentoDao;

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public String listar(
            @RequestParam(value = "opcao-ordenar", required = false, defaultValue = "cre") String tipoDeOrdenacao,
            Alimento alimento,
            Model model) {

        if (!alimentoDao.getAlimentos().isEmpty()) {
            if (tipoDeOrdenacao != null) {
                if (tipoDeOrdenacao.equals("cre")) {
                    Collections.sort(alimentoDao.getAlimentos());
                }
            }

            if (tipoDeOrdenacao != null) {
                if (tipoDeOrdenacao.equals("decre")) {
                    Collections.sort(alimentoDao.getAlimentos());
                    Collections.reverse(alimentoDao.getAlimentos());
                }
            }

            model.addAttribute("alimento", new Alimento());
            model.addAttribute("alimentos", alimentoDao.getAlimentos());

        }
        else {
            model.addAttribute("erro", "Nenhum alimento encontrado!");
        }
        return "lista";
    }


    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    public String busca(Alimento alimento, Model model) {
        List<Alimento> resultadoBusca = alimentoDao.find(alimento);

        if (!resultadoBusca.isEmpty()) {
            model.addAttribute("alimentos", resultadoBusca);
        } else {
            model.addAttribute("erro", "Nenhum alimento encontrado!");
        }


        return "lista";
    }

    @RequestMapping(value = "/buscaCategoria", method = RequestMethod.GET)
    public String buscaPorCategoria(@RequestParam(value = "categoria") String categoria, Model model) {
        model.addAttribute("alimento", new Alimento());
        
        Categoria categoriaBusca = new Categoria();
        categoriaBusca.setNomeCategoria(categoria);

        CategoriaDAO catDao = new CategoriaDAO();
        List<Categoria> listCategoria = catDao.find(categoriaBusca);

       List<Alimento> resultadoBusca = alimentoDao.findPorCategoria(listCategoria.get(0));

       if (!resultadoBusca.isEmpty()) {
           model.addAttribute("alimentos", resultadoBusca);
        } else {
           model.addAttribute("erro", "Nenhum Alimento encontrado!");
      }

        return "lista";
    }
}