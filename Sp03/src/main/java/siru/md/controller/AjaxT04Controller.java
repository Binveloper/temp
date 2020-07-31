package siru.md.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;
import siru.md.domain.Address;
import siru.md.service.AddressAjaxService;

@RestController //jsp, model and view ���� �Ұ���
@RequestMapping("ajax04")
@Log4j
public class AjaxT04Controller {
	
	@Autowired
	private AddressAjaxService service;
	@GetMapping(value = "search01",
				produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Address search01(long seq) {
		Address address = service.selectBySeqS(seq);
		return address;
	}
	
	/*
	MediaType�� header�� ���ԵǴ� application/json;charset=UTF-8�� ���� content Type�� ����ν� ����� �� �ֵ��� �����ִ� api�Դϴ�.
	�̰��� ����ϹǷν� ���ڿ��� ���� �ͺ��� type safe�� ȿ���� ���� �� �ֽ��ϴ�.
	consumes�� �����δ� ���ڿ��� �;� �ϱ� ������ MediaType.APPLICATION_JSON_UTF8_VALUE�� ����� ���� �� �� �ֽ��ϴ�.
	����� �� �ڿ� _VALUE�� �پ��ִ� ��쿡�� ��ü�� �ƴ� ���ڿ��� �� ���� ������ �˴ϴ�.
	MediaType��ü�� �Ű������� ���ϴ� �������� _VALUE�� ���� ���� ����� ����ϸ� �˴ϴ�.
	
	*/
	 
	@PostMapping(value = "search02",
				 produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Address> search02(String name) {
		List<Address> list = service.selectByNameS(name);
		return list;
	}
}
