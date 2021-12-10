package com.example.demo;

import java.time.LocalDate;
import java.util.Set;

import javax.swing.Spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.EMI;
import com.example.demo.layer2.EMICard;
import com.example.demo.layer2.Orders;
import com.example.demo.layer2.PaymentAndInstallment;
import com.example.demo.layer2.Product;
import com.example.demo.layer2.User;
import com.example.demo.layer3.BaseRepository;
import com.example.demo.layer3.EMICardRepoImpl;
import com.example.demo.layer3.EMIRepoImpl;
import com.example.demo.layer3.OrdersRepoImpl;
import com.example.demo.layer3.PaymentAndInstallmentRepoImpl;
import com.example.demo.layer3.ProductRepoImpl;
import com.example.demo.layer3.UserRepoImpl;

@SpringBootTest
class FinanceApplicationTests {
	@Autowired
	UserRepoImpl u;
	@Autowired
	ProductRepoImpl p;
	@Autowired
	PaymentAndInstallmentRepoImpl i;
	@Autowired
	OrdersRepoImpl o;
	@Autowired
	EMICardRepoImpl c;
	@Autowired
	EMIRepoImpl e;

	@Test
	void insertUser() {

		User user1 = new User("Avinash", LocalDate.of(1998, 02, 01), 38738838l, "avinasugale@gmail.com",
				"password", "Pune", "AZ2636", "HDFC", "hdfc003", 123456789l);

		User user2 = new User("Lokesk Patil", LocalDate.of(1998, 01, 01), 3838388838l, "patillokesh@gmail.com",
				"password", "Wakad", "CXZ3115G", "HDFC", "hdfc003", 123456789l);
		u.insertUser(user2);
		u.insertUser(user1);
	}
	

//	@Test
//	void insertProduct() {
//		Product product1 = new Product("Product 1", "Product 1 details", "Product Card1");
//		Product product2 = new Product("Product 2", "Product 2 details", "Product Card2");
//		Product product3 = new Product("Product 3", "Product 3 details", "Product Card3");
//		p.insertProduct(product1);
//		p.insertProduct(product2);
//		p.insertProduct(product3);
//	}

	@Test
	void insertPayment() {
		PaymentAndInstallment installment1 = new PaymentAndInstallment(LocalDate.of(2021, 12, 01), 123.45f, 1, 123.45f);
		PaymentAndInstallment installment2 = new PaymentAndInstallment(LocalDate.of(2021, 12, 01), 123.45f, 2,
				123.45f + 123.45f);

		i.insertInstallment(installment1);
		i.insertInstallment(installment2);
	}

	@Test
	void insertOrders() {
		Orders order1 = new Orders(LocalDate.of(2021, 12, 01), "Scheme 1");

		Orders order2 = new Orders(LocalDate.of(2021, 12, 02), "Scheme 2");

		Orders order3 = new Orders(LocalDate.of(2021, 12, 03), "Scheme 1");

		o.insertOrder(order1);
		o.insertOrder(order2);
		o.insertOrder(order3);
	}

	@Test
	void insertEMICard() {
		EMICard card1 = new EMICard("Gold", 12000l, 120000l);

		EMICard card2 = new EMICard("Titanum", 120000l, 1200000l);
		EMICard card3 = new EMICard();
		card3.setCardType("Platnium");
		card3.setCostOfCard(12345l);
		card3.setCardLimit(123456789l);
		c.insertEMICard(card3);
		c.insertEMICard(card1);
		c.insertEMICard(card2);
	}

	@Test
	void insertEMI() {
		EMI emi1 = new EMI(12345f, LocalDate.of(2022, 12, 01));

		EMI emi2 = new EMI(1235f, LocalDate.of(2022, 12, 01));

		e.insertEMI(emi1);
		e.insertEMI(emi2);
	}

	@Test
	void oneToOneTest() {

		User user = u.selectUser(21);
		EMICard card1 = c.selectEmiCard(28);

		user.setEmiCard(card1);
		card1.setUser(user);
		u.merge(card1);
		c.merge(user);
		
		
		
		
	}
	@Test
	void oneToManyTest() {
		
		User user1=u.selectUser(21);
		Set<Orders> ol1=user1.getUserOrderSet();
		Orders order1=o.selectOrder(37);
		Orders order2=o.selectOrder(38);
		
		order1.setUserOrderId(user1);
		order2.setUserOrderId(user1);
		ol1.add(order1);
		ol1.add(order2);
		u.updateUser(user1);
		o.updateOrders(order1);
		o.updateOrders(order2);
	}
	
}
