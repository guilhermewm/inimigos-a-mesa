package br.com.aceleradora.inimigosamesa.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by aluno03 on 05/08/15.
 */
public class CalculadoraTeste {

    Calculadora calculadora = new Calculadora();

    @Test
    public void QuandoPassamosUmAlimentoEntaoRetornaOProprioValor() throws Exception {

        Calculadora calculadora = new Calculadora();
        List<Alimento> valorEsperado = new ArrayList<Alimento>();
        List<Alimento> valorRetornado = calculadora.getListaDeAlimentos();
        assertEquals("Não deve retornar null:",valorEsperado,valorRetornado);
    }

//    @Test
//    public void somaTotalDeAlimentosDaCalculadoraTest(){
//        Calculadora calculadora = new Calculadora();
//
//        Alimento alimento2 = new Alimento();
//
//        alimento2.setCodigo(1);
//
//        double valorEsperado = 0.0;
//
//        double valorRetornado = calculadora.getCaloriasTotal();
//        assertEquals("Deve retornar zero calorias.", valorEsperado, valorRetornado, 0);
//        valorRetornado = calculadora.getGorduraTotal();
//        assertEquals("Deve retornar zero gordura.",valorEsperado,valorRetornado,0);
//        valorRetornado = calculadora.getSodioTotal();
//        assertEquals("Deve retornar zero sal.",valorEsperado,valorRetornado,0);
//        valorRetornado = calculadora.getAcucarTotal();
//        assertEquals("Deve retornar zero açucar.",valorEsperado,valorRetornado,0);
//
//        calculadora.adicionaAlimento(alimento2);
//
//        valorEsperado = 2000.0;
//        valorRetornado = calculadora.getCaloriasTotal();
//        assertEquals("Deve retornar 2000 calorias.",valorEsperado,valorRetornado,0);
//
//        valorEsperado = 2000.0;
//        valorRetornado = calculadora.getGorduraTotal();
//        assertEquals("Deve retornar 2000 gordura.",valorEsperado,valorRetornado,0);
//
//        valorEsperado = 5.0;
//        valorRetornado = calculadora.getSodioTotal();
//        assertEquals("Deve retornar 2000 sodio.",valorEsperado,valorRetornado,0);
//
//        valorEsperado = 2000.0;
//        valorRetornado = calculadora.getAcucarTotal();
//        assertEquals("Deve retornar 2000 acucar.",valorEsperado,valorRetornado,0);
//
//
//        valorEsperado = 0.01;
//        valorRetornado = calculadora.getSalTotal();
//        assertEquals("Deve retornar 0.0128205128 sal.",valorEsperado,valorRetornado,0);
//
//    }
}
