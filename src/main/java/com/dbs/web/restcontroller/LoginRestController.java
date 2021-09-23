package com.dbs.web.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.web.beans.Bank;
import com.dbs.web.beans.Currency;
import com.dbs.web.beans.Customer;
import com.dbs.web.beans.Employee;
import com.dbs.web.beans.Message;
import com.dbs.web.beans.Transfertypes;
import com.dbs.web.exception.EntityNotFoundException;
import com.dbs.web.response.ResponsePage;
import com.dbs.web.service.BankService;
import com.dbs.web.service.CurrencyService;
import com.dbs.web.service.CustomerService;
import com.dbs.web.service.MessageService;
import com.dbs.web.service.SanctionListService;
import com.dbs.web.service.TransfertypesService;

@RestController
@CrossOrigin(origins = "*")
public class LoginRestController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private TransfertypesService transferTypesService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private SanctionListService sanctionListService;
	
	public LoginRestController() {
		
		System.out.println("Sample Rest Constroller");
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> getLoginValidation(@RequestBody Customer customer) {
		List<Customer> cstList =  new ArrayList<>();
		try {
			 cstList = this.customerService.findCustomerByUsername(customer.getUserName());
			 if((!(cstList.size()>0)) ||!cstList.get(0).getUserPassword().equals(customer.getUserPassword()) ) {
		
					throw new EntityNotFoundException();
			 }
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				cstList.get(0));
	
	}
	
	@PostMapping("/login1")
	public Customer getLoginValidation1(@RequestBody Customer customer) {
		List<Customer> cstList =  new ArrayList<>();
		try {
			 cstList = this.customerService.findCustomerByUsername(customer.getUserName());
			 if((!(cstList.size()>0)) ||!cstList.get(0).getUserPassword().equals(customer.getUserPassword()) ) {
		
					throw new EntityNotFoundException();
			 }
		}
		catch(Exception e )
		{
			return null;
		}
		return cstList.get(0);
	
	}
	
	@PostMapping("/getBankNameFromBIC")
	public ResponseEntity<Object> getBankNameByBic(@RequestBody Bank recevierData) {
		Bank bank = null;
		try {
			 bank = this.bankService.findBankByBIC(recevierData.getBic());
			 
			 if(bank.getBankName()==null || bank.getBankName().isEmpty() || bank.getBankName().isBlank()) {
				 throw new EntityNotFoundException();
				 }
			
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				bank);
	}
	
	@PostMapping("/validateAccountHolderNumber")
	public ResponseEntity<Object> getAccountDetailsByAccountNumber(@RequestBody Customer customer) {

		Customer receiverData = null;
		
		try {
			System.out.println("Entered customerverify :"+customer.getCustomerId());
			
			System.out.println("Customer type is :"+customer.getUserName());
			if(customer.getCustomerId().equals(customer.getUserName())) {
				System.out.println("same id");
				throw new EntityNotFoundException();
			}
			
			System.out.println("customer:::"+customer);
			
			
			Customer temp = this.customerService.findCustomerById(customer.getUserName());
		
			System.out.println("Customer type is :"+customer.getUserName());
			
			receiverData = this.customerService.findCustomerById(customer.getCustomerId());
			System.out.println(receiverData.getCustomerType());
			
			System.out.println("testing"+temp.getCustomerType().equals(receiverData.getCustomerType()));
			if(!temp.getCustomerType().equals(receiverData.getCustomerType())|| receiverData==null) {
				System.out.println(":::::::::::"+temp.getCustomerType());
				 throw new EntityNotFoundException();
			}
			
		}
		catch(Exception e )
		{
			System.out.println("Entered error block");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer didnt exists with given customer id");
		}
		System.out.println("Didnt enter error block");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(receiverData);
	}
	
	@PostMapping("/verifyAccountName")
	public ResponseEntity<Object> getSanctionListMacthByName(@RequestBody Customer customer) {
		try {
			System.out.println("Entered sdnlist :"+customer.getAccountHolderName());
			
			if(customer.getAccountHolderName().isBlank()|| customer.getAccountHolderName().isEmpty() ||
					this.sanctionListService.getNameMatchedInSanctionList(customer.getAccountHolderName())) {
				
			throw new EntityNotFoundException();
			}
		}
		catch(Exception e )
		{
			System.out.println("Entered error block");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new String("Given Account Holder Name found in Sanction List"));
		}
		System.out.println("Didnt enter error block");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new String(
				"Transfer can be proceeded"));
	}
	
	@PostMapping("/validateTransaction")
	public ResponseEntity<Object> transactionValidation(@RequestBody Customer customer) {
		Customer sender = null;
		Customer receiver = null;
		try {
			
			System.out.println("customer :+++"+customer);
			sender = this.customerService.findCustomerById(customer.getCustomerId());
			
			receiver = this.customerService.findCustomerById(customer.getUserName());
			
			if(sender.getClearBalance()<customer.getClearBalance() && sender.getOverDraftFlag()==0) {
				System.out.println(":::"+sender.getClearBalance()+":"+customer.getClearBalance());
				throw new EntityNotFoundException();
			}
			
			sender.setClearBalance(sender.getClearBalance()-customer.getClearBalance()>0?
					sender.getClearBalance()-customer.getClearBalance():0);
					
			this.customerService.updateCustomer(sender);
			receiver.setClearBalance(receiver.getClearBalance()+customer.getClearBalance());
			this.customerService.updateCustomer(receiver);
			
		}
		catch(Exception e )
		{
			System.out.println("Entered error block");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new String("Sender do not have required amount "));
		}
		
		System.out.println("Didnt enter error block");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new String(
				"Transfer can be proceeded"));
	}
	
	@GetMapping("/transfer")
	public ResponseEntity<Object> getTransferTypes()
	{ 
		List<Transfertypes> transferTypesList = new ArrayList<>();
		
		try {
			transferTypesList = this.transferTypesService.getAllTransferTypes();
		}
		catch(Exception e )
		{
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not retrieve transfer types");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transferTypesList);
	}
	
	
	
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<ResponsePage> getLoginValidation(@PathVariable String username,@PathVariable String password) {
		List<Customer> cstList =  new ArrayList<>();
		try {
			 cstList = this.customerService.findCustomerByUsername(username);
			 if((!(cstList.size()>0)) ||!cstList.get(0).getUserPassword().equals(password) ) {
		
					throw new EntityNotFoundException();
			 }
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsePage(400, e.getMessage()));
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponsePage(200, 
				"found"));
	
	}
	@GetMapping("/customer/{customerid}")
	public ResponseEntity<ResponsePage> getCustomerDetails(@PathVariable String customerid)
	{ 
		 Customer customer = null;
		try {
			 customer = this.customerService.findCustomerById(customerid);
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsePage(400, e.getMessage()));
		}
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponsePage(200, 
			//	customer.getAccountHolderName()+" "+customer.getClearBalance()));
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponsePage(200, 
				customer.toString()));
	}
	@GetMapping("/test")
	public Customer getCustomerDetails1()
	{ 
		 Customer customer = null;
		try {
			 customer = this.customerService.findCustomerById("71319440983198");
		}
		catch(Exception e )
		{
			return null;
		}
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponsePage(200, 
			//	customer.getAccountHolderName()+" "+customer.getClearBalance()));
		return customer;
	}
	
	@GetMapping("/bank/{bic}")
	public ResponseEntity<ResponsePage> getBankName(@PathVariable String bic)
	{ 
		 Bank bank;
		try {
			 bank = this.bankService.findBankByBIC(bic);
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsePage(400, e.getMessage()));
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponsePage(200, 
				bank.getBankName()));
	}
	
	@GetMapping("/messages")
	public ResponseEntity<Object> getMessages()
	{ 
		List<Message> messagesList = new ArrayList<>();
		
		try {
			messagesList = this.messageService.getAllMessages();
		}
		catch(Exception e )
		{
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not retrieve transfer types");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(messagesList);
	}
	
	/*
	@GetMapping("/messages")
	public List<Message> getMessages()
	{ 
		return this.messageService.getAllMessages();
	}
	*/
	
	@GetMapping("/currency")
	public List<Currency> getAllCurrencies()
	{ 
		return this.currencyService.getAllCurrencies();
	}
	

}
