/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.register.services.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class RegisterSoap implements Serializable {

	public static RegisterSoap toSoapModel(Register model) {
		RegisterSoap soapModel = new RegisterSoap();

		soapModel.setRid(model.getRid());
		soapModel.setName(model.getName());
		soapModel.setSurname(model.getSurname());
		soapModel.setBdate(model.getBdate());
		soapModel.setEmail(model.getEmail());
		soapModel.setRegdate(model.getRegdate());

		return soapModel;
	}

	public static RegisterSoap[] toSoapModels(Register[] models) {
		RegisterSoap[] soapModels = new RegisterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RegisterSoap[][] toSoapModels(Register[][] models) {
		RegisterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RegisterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RegisterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RegisterSoap[] toSoapModels(List<Register> models) {
		List<RegisterSoap> soapModels = new ArrayList<RegisterSoap>(
			models.size());

		for (Register model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RegisterSoap[soapModels.size()]);
	}

	public RegisterSoap() {
	}

	public long getPrimaryKey() {
		return _rid;
	}

	public void setPrimaryKey(long pk) {
		setRid(pk);
	}

	public long getRid() {
		return _rid;
	}

	public void setRid(long rid) {
		_rid = rid;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSurname() {
		return _surname;
	}

	public void setSurname(String surname) {
		_surname = surname;
	}

	public Date getBdate() {
		return _bdate;
	}

	public void setBdate(Date bdate) {
		_bdate = bdate;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getRegdate() {
		return _regdate;
	}

	public void setRegdate(Date regdate) {
		_regdate = regdate;
	}

	private long _rid;
	private String _name;
	private String _surname;
	private Date _bdate;
	private String _email;
	private Date _regdate;

}