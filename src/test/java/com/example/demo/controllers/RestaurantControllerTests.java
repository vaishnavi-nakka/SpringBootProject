package com.example.demo.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.domain.Restaurant;
import com.example.demo.service.RestaurantService;
import com.example.demo.service.RestaurantServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")

public class RestaurantControllerTests {


    private RestaurantController restaurantController;

    private MockMvc mockMvc;

    @Autowired
    private RestaurantServiceImpl restaurantServiceImpl;

    @Before
    public void setupMock() {
    	
        // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under
        // test.
    	restaurantController = new RestaurantController();
        MockitoAnnotations.initMocks(this);
        restaurantController.setRestaurantService(restaurantServiceImpl);
        mockMvc = MockMvcBuilders.standaloneSetup(restaurantServiceImpl).build();
    }

	
	@Test
	public void testFindAll() throws Exception {

		Restaurant first = new Restaurant();
		first.setRestaurantId(1);
		first.setRestaurantLoc("Bglr");
		first.setCostOfTwo(new BigDecimal(2000));
		first.setRestaurantName("Truffles");
		
		Restaurant second = new Restaurant();
		first.setRestaurantId(2);
		first.setRestaurantLoc("Bglr1");
		first.setCostOfTwo(new BigDecimal(20002));
		first.setRestaurantName("Truffles1");
		
		when(restaurantServiceImpl.findAll()).thenReturn(Arrays.asList(first, second));

		mockMvc.perform(get("/api/v1/restaurant/"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
    				.andExpect(jsonPath("$[0].restaurantId", is(1)))
	                .andExpect(jsonPath("$[0].restaurantName", is("Truffles")))
	                .andExpect(jsonPath("$[0].restaurantLoc", is("Bglr")))
	                .andExpect(jsonPath("$[0].costOfTwo", is(2000)))
	                .andExpect(jsonPath("$[1].restaurantId", is(2)))
	                .andExpect(jsonPath("$[1].restaurantName", is("Truffles1")))
	                .andExpect(jsonPath("$[1].restaurantLoc", is("Bglr1")))
	                .andExpect(jsonPath("$[1].costOfTwo", is(20002)));
		
		verify(restaurantServiceImpl, times(1)).findAll();
		verifyNoMoreInteractions(restaurantServiceImpl);


		
        
    }
	
	
}
