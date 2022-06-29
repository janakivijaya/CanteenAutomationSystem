package com.example.springCore.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springCore.entity.Payment;
import com.example.springCore.exception.PaymentNotFoundException;
import com.example.springCore.service.IPaymentService;


@RestController
public class PaymentController {
	//constructor injection/setter injection/field injection
	@Autowired
	IPaymentService payServ;
	
	//get all payments
	@GetMapping("/payments")
	ResponseEntity<List<Payment>> getAllPayments(){
		List<Payment> payments = payServ.getAllPayments();
		return new ResponseEntity<>(payments, HttpStatus.OK);
	}
	
	//get all payment based on id
	@GetMapping("/payment/{id}")
	ResponseEntity<List<Payment>> getPaymentById(@PathVariable("id")int id)
	{
	   List<Payment>payment = payServ.getPaymentById(id);
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}
	/*
	//update payment
	@PutMapping("/payment/{id}")
	ResponseEntity<Payment> updatePaymentById(@RequestBody Payment payment, @PathVariable("id") int paymentId)
	{
	
		Payment updatePay = payServ.updatePaymentById(paymentId,payment);
		return new ResponseEntity<>(payment,HttpStatus.OK);
	}
	*/
	// get total payment
	@GetMapping("/payment/{TotalPayment}")
	ResponseEntity<List<Payment>> getPaymentByTotalPayment(@PathVariable("TotalPayment") double payment){
		
		List<Payment>payment1 = payServ.getPaymentByTotalPayment(payment);
		return new ResponseEntity<>(payment1, HttpStatus.OK);
		
	}
	
	//get payment Type
	@GetMapping("/payment/{PaymentType}")
	ResponseEntity<List<Payment>> getPaymentByPaymentType(@PathVariable("PaymentType") String CreditCard ){
	
	List<Payment>payment = payServ.getPaymentByPaymentType(CreditCard);
	return new ResponseEntity<>(payment, HttpStatus.OK);
	}
	
	// add payment
		@PostMapping("/payment")
		ResponseEntity<Payment> addPayment(@Valid @RequestBody Payment payment) {
			Payment newPay = payServ.addPayment(payment);
			return new ResponseEntity<>(newPay, HttpStatus.CREATED);
		}
	

}
	
	