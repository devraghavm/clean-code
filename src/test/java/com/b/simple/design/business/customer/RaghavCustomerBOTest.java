package com.b.simple.design.business.customer;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaghavCustomerBOTest {

	private CustomerBO customerBO = new CustomerBOImpl();

	@Test
	public void testCustomerProductSum_TwoProductsSameCurrencies()
			throws DifferentCurrenciesException {
		// Setup

		Amount[] amounts = {
				new AmountImpl(new BigDecimal("5.0"), Currency.EURO),
				new AmountImpl(new BigDecimal("6.0"), Currency.EURO)
		};
		Amount expected = new AmountImpl(new BigDecimal("11.0"), Currency.EURO);

		List<Product> products = createProductsWithAmounts(amounts);

		// Invoke
		Amount actual = customerBO.getCustomerProductsSum(products);

		// Verify
		assertAmount(expected, actual);
	}

	@Test
	public void testCustomerProductSum_TwoProductsDifferentCurrencies()
			throws DifferentCurrenciesException {
		// Setup

		Amount[] amounts = {
				new AmountImpl(new BigDecimal("5.0"), Currency.EURO),
				new AmountImpl(new BigDecimal("6.0"), Currency.INDIAN_RUPEE)
		};

		List<Product> products = createProductsWithAmounts(amounts);

		// Invoke
		Assertions.assertThrows(DifferentCurrenciesException.class, () -> {
			customerBO.getCustomerProductsSum(products);
		});
	}

	@Test
	public void testCustomerProductSum_EmptyProducts() throws DifferentCurrenciesException {

		Amount actual = customerBO.getCustomerProductsSum(new ArrayList<Product>());
		Amount expected = new AmountImpl(BigDecimal.ZERO, Currency.EURO);

		assertAmount(expected, actual);
	}

	private void assertAmount(Amount expected, Amount actual) {
		assertEquals(expected.getCurrency(), actual.getCurrency());
		assertEquals(expected.getValue(), actual.getValue());
	}

	private List<Product> createProductsWithAmounts(Amount[] amounts) {
		return Arrays.stream(amounts)
				.map(amount -> new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE,
				amount))
				.collect(Collectors.toList());
/*		List<Product> products = new ArrayList<>();
		for (Amount amount :
				amounts) {
			products.add(new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE,
					amount));
		}
		return products;*/
	}

}