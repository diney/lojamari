package com.lojamari.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.lojamari.domain.Cliente;
import com.lojamari.dto.ClienteDTO;
import com.lojamari.repository.ClienteRepository;
import com.lojamari.resources.exception.FieldMessage;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteDTO> {

	@Autowired
	private ClienteRepository repo;

	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		/*
		 * if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) &&
		 * !BR.isValidCPF(objDto.getCpfOuCnpj())) { list.add(new
		 * FieldMessage("cpfOuCnpj", "CPF inválido")); }
		 */

		/*
		 * if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) &&
		 * !BR.isValidCNPJ(objDto.getCpfOuCnpj())) { list.add(new
		 * FieldMessage("cpfOuCnpj", "CNPJ inválido")); }
		 */
         if(objDto.getEmail()!=null) {
        	 Cliente aux = repo.findByEmail(objDto.getEmail());
     		if (aux != null) {
     			list.add(new FieldMessage("email", "Email já existente"));
     		} 
         }
		
		
		/*
		 * if (objDto.getEmail()==null) {
		 * 
		 * for (FieldMessage e : list) { context.disableDefaultConstraintViolation();
		 * context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(
		 * e.getFieldName()) .addConstraintViolation(); } return list.isEmpty();}
		 */
		/*
		 * if (aux.equals( " ")){ for (FieldMessage e : list) {
		 * context.disableDefaultConstraintViolation();
		 * context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(
		 * e.getFieldName()) .addConstraintViolation(); } return list.isEmpty();
		 * 
		 * }
		 */
			for (FieldMessage e : list) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
						.addConstraintViolation();
			}
			return list.isEmpty();
		}
		

	}

