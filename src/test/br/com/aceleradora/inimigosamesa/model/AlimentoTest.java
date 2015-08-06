package br.com.aceleradora.inimigosamesa.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mentores on 29/07/15.
 */
public class AlimentoTest {

    @Test
    public void quandoValorForIgualANullEntaoRetornaOMesmoValor() throws Exception {
        Alimento alimento = new Alimento("abacate", "0", "0", null, "0", "0", "0", "0", "0", "0", "0", "0", new Categoria(1), "", "");

        String valorEsperado = null;
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoValorForIgualAVazioEntaoRetornaOMesmoValor() throws Exception {
        Alimento alimento = new Alimento("abacate", "0", "0", "", "0", "0", "0", "0", "0", "0", "0", "0", new Categoria(1), "", "");

        String valorEsperado = "";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoPorcaoExibicaoForIgualAPorcaoBaseCalculoEntaoRetornaOMesmoValor() throws Exception {
        Alimento alimento = new Alimento("abacate", "0", "0", "10", "0", "100", "0", "100", "0", "0", "0", "0", new Categoria(1), "", "");

        String valorEsperado = "10";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoPorcaoExibicaoForMenorQueAPorcaoBaseCalculoEntaoCalculaOValorASerExibido() throws Exception {
        Alimento alimento = new Alimento("abacate", "0", "0", "10", "0", "100", "0", "70", "0", "0", "0", "0", new Categoria(1), "", "");

        String valorEsperado = "7.0";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoPorcaoExibicaoForMaiorQueAPorcaoBaseCalculoEntaoCalculaOValorASerExibido() throws Exception {
        Alimento alimento = new Alimento("abacate", "0", "0", "10", "0", "100", "0", "200", "0", "0", "0", "0", new Categoria(1), "", "");

        String valorEsperado = "20.0";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoOValorRecebidoForNullEntaoRetornaFalse() throws Exception {
        Alimento alimentoValida = new Alimento();
        assertTrue(!alimentoValida.validaValor(null));
    }

    @Test
    public void quandoOValorRecebidoForVazioEntaoRetornaFalse() throws Exception {
        Alimento alimentoValida = new Alimento();
        assertTrue(!alimentoValida.validaValor(""));
    }

    @Test
    public void quandoOValorRecebidoContemLetrantaoRetornaTrue() throws Exception {
        Alimento alimentoValida = new Alimento();
        assertTrue(alimentoValida.validaValor("nd"));
    }

}