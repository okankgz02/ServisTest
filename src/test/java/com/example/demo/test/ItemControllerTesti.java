package com.example.demo.test;

import com.example.demo.Item;
import com.example.demo.ItemBusinessService;
import com.example.demo.ItemController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTesti {

  @Autowired
  private MockMvc mockMvc;

  @MockBean//Spring kütüphaneleri dahil edilir Diğer @Mokctan farkı
  private ItemBusinessService businessService;

  @Test
  public void dummyItem_basic() throws Exception {

    RequestBuilder request =MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
    MvcResult result =
        mockMvc
            .perform(request)
            .andExpect(status().isOk())
            .andExpect(
                content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
            .andReturn();

    //String expected = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    // JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }

  @Test
  public void itemFromBusinessService_basic() throws Exception {

    when(businessService.retreiveHardcodedItem()).thenReturn(new Item(2,"Item2",10,10));

    RequestBuilder request =
            MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);
    MvcResult result =
            mockMvc
                    .perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().json("{id:2,name:Item2,price:10,quantity:10}"))
                    .andReturn();

    //String expected = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    // JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
  }

}
//MockBean sprin kütüphanelerini dahil eder