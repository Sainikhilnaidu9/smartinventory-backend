package com.capstone.smartinventorymanagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capstone.smartinventorymanagement.controller.CartController;
import com.capstone.smartinventorymanagement.dto.CartDto;
import com.capstone.smartinventorymanagement.model.Cart;
import com.capstone.smartinventorymanagement.service.CartService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CartControllerTest {

    @InjectMocks
    CartController cartController;

    @Mock
    private CartService cartService;

    @Test
    public void getCartDetailsByIdTest() throws Exception {
        int cartId = 17;
        CartDto dto = new CartDto();
        // Set properties of dto as needed for the test
        Mockito.when(cartService.findCartDetailsById(cartId)).thenReturn(dto);

        CartDto cartDto = cartController.getCartDetailsById(cartId);
        assertEquals(cartDto, dto);
    }

    @Test
    public void postCartDetailsTest() throws Exception {
        Cart cart = new Cart();
        // Set properties of cart as needed for the test
        Mockito.when(cartService.insertCartDetails(cart)).thenReturn("Cart details created successfully");

        String successMessage = cartController.postCartDetails(cart);
        assertEquals(successMessage, "Cart details created successfully");
    }

    @Test
    public void putCartDetailsTest() throws Exception {
        int cartId = 17;
        Cart cart = new Cart();
        // Set properties of cart as needed for the test
        Mockito.when(cartService.updateCartDetails(cart, cartId)).thenReturn("Cart details updated successfully");

        String successMessage = cartController.putCartDetails(cart, cartId);
        assertEquals(successMessage, "Cart details updated successfully");
    }

    @Test
    public void removeCartDetailsTest() throws Exception {
        int cartId = 17;
        Mockito.when(cartService.deleteCartDetails(cartId)).thenReturn("Cart details deleted successfully");

        String successMessage = cartController.removeCartDetails(cartId);
        assertEquals(successMessage, "Cart details deleted successfully");
    }

    
}
