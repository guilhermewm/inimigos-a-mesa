package controller;

import DAO.AlimentoDAO;
import model.Alimento;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BuscaController {


    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    public String busca(Alimento alimento) {
        return "busca";
    }


    @RequestMapping(value = "/busca", method = RequestMethod.POST)
    public String populaAlimento(Alimento alimento, BindingResult bindingResult, Model model) {

        AlimentoDAO adao = new AlimentoDAO();
        Alimento abusca = adao.find(alimento);

        if (abusca != null) {
            model.addAttribute("nomeAlimento", "Nome: " + abusca.getNomeAlimento());
            model.addAttribute("quantidadeAcucarGramas", "Açucar: " + abusca.getQuantidadeAcucarGramas());
            model.addAttribute("quantidadeSodioMiligramas", "Sódio: " + abusca.getQuantidadeSodioMiligramas());
            model.addAttribute("quantidadeGorduraGramas", "Gordura: " + abusca.getQuantidadeGorduraGramas());
        } else {
            model.addAttribute("nomeAlimento", "Alimento não encontrado!");
        }
        return "busca";

    }

}
