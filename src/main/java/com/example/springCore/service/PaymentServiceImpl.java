package com.example.springCore.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springCore.entity.Payment;
import com.example.springCore.exception.PaymentNotFoundException;
import com.example.springCore.repository.IPaymentRepository;
@Service
public class PaymentServiceImpl implements IPaymentService{
	
	@Autowired
	IPaymentRepository payRepo;
	
	@Override
	public List<Payment> getAllPayment(){
		return payRepo.findAll();
	}
	
	@Override
	public Payment addPayment(Payment payment) {
		return payRepo.save(payment);
	}
	
/*
	//update payment id
	@Override
	public Payment updatePaymentId(int payId) {
		
		//find pay by id 
			return.payRepo.save(dbPay);
			
		}else {
			//if pay not found in db, return null or throw exception
			return null;
		}*/
		@Override
		public List<Payment> getPaymentById(int PaymentId){
			
			return payRepo.findByPaymentId(PaymentId);
			
		}
		@Override
		public List<Payment> getPaymentByTotalPayment(double TotalPayment){
			
			return payRepo.findByTotalPayment(TotalPayment);
		}
		@Override
		public List<Payment> getPaymentByPaymentType(String PaymentType){
			
			return payRepo.findByPaymentType(PaymentType);
		}
@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return payRepo.findAll();
		
	}
@Override
public Payment updatePaymentById(int paymentId, Payment payment) {
	// TODO Auto-generated method stub
	return null;
    }

@Override
public Payment addPayment1(Payment payment) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Payment getPayById(int payId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Payment updatePaymentId(int payId) {
	// TODO Auto-generated method stub
	return null;
    }


		
}
