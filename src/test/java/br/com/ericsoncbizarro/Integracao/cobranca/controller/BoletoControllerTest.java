package br.com.ericsoncbizarro.Integracao.cobranca.controller;

import br.com.ericsoncbizarro.Integracao.cobranca.model.modelPulsarPay.Boleto;
import br.com.ericsoncbizarro.Integracao.cobranca.services.BoletoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BoletoControllerTest {

     @InjectMocks
     BoletoController controllerToTest;

    @Mock
    BoletoService service;

    @Test
    public void testFindAll() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        List<Boleto> listaBoletosFromService = new ArrayList<>();
        Boleto boleto1 = new Boleto();
        boleto1.setNosso_numero("123");
        boleto1.setBoleto_id("1");
        boleto1.setValor("10");

        Boleto boleto2 = new Boleto();
        boleto2.setNosso_numero("456");
        boleto2.setBoleto_id("2");
        boleto2.setValor("100");

        listaBoletosFromService.add(boleto1);
        listaBoletosFromService.add(boleto2);
        when(service.findAll()).thenReturn(listaBoletosFromService);

        List<Boleto> listaBoletosFromController = controllerToTest.findAll();

        assertThat(listaBoletosFromController.size()).isEqualTo(listaBoletosFromService.size());
        assertThat(listaBoletosFromController.get(0).getBoleto_id()).isEqualTo(listaBoletosFromService.get(0).getBoleto_id());
        assertThat(listaBoletosFromController.get(0).getValor()).isEqualTo(listaBoletosFromService.get(0).getValor());

        assertThat(listaBoletosFromController.get(1).getBoleto_id()).isEqualTo(listaBoletosFromService.get(1).getBoleto_id());
        assertThat(listaBoletosFromController.get(1).getValor()).isEqualTo(listaBoletosFromService.get(1).getValor());

        // assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        // assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");

    }
}
