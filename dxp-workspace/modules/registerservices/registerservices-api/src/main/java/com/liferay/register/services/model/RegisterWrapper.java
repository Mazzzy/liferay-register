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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Register}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Register
 * @generated
 */
public class RegisterWrapper
	extends BaseModelWrapper<Register>
	implements ModelWrapper<Register>, Register {

	public RegisterWrapper(Register register) {
		super(register);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rid", getRid());
		attributes.put("name", getName());
		attributes.put("surname", getSurname());
		attributes.put("bdate", getBdate());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rid = (Long)attributes.get("rid");

		if (rid != null) {
			setRid(rid);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String surname = (String)attributes.get("surname");

		if (surname != null) {
			setSurname(surname);
		}

		Date bdate = (Date)attributes.get("bdate");

		if (bdate != null) {
			setBdate(bdate);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
	}

	/**
	 * Returns the bdate of this register.
	 *
	 * @return the bdate of this register
	 */
	@Override
	public Date getBdate() {
		return model.getBdate();
	}

	/**
	 * Returns the email of this register.
	 *
	 * @return the email of this register
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the name of this register.
	 *
	 * @return the name of this register
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this register.
	 *
	 * @return the primary key of this register
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rid of this register.
	 *
	 * @return the rid of this register
	 */
	@Override
	public long getRid() {
		return model.getRid();
	}

	/**
	 * Returns the surname of this register.
	 *
	 * @return the surname of this register
	 */
	@Override
	public String getSurname() {
		return model.getSurname();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bdate of this register.
	 *
	 * @param bdate the bdate of this register
	 */
	@Override
	public void setBdate(Date bdate) {
		model.setBdate(bdate);
	}

	/**
	 * Sets the email of this register.
	 *
	 * @param email the email of this register
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the name of this register.
	 *
	 * @param name the name of this register
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this register.
	 *
	 * @param primaryKey the primary key of this register
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rid of this register.
	 *
	 * @param rid the rid of this register
	 */
	@Override
	public void setRid(long rid) {
		model.setRid(rid);
	}

	/**
	 * Sets the surname of this register.
	 *
	 * @param surname the surname of this register
	 */
	@Override
	public void setSurname(String surname) {
		model.setSurname(surname);
	}

	@Override
	protected RegisterWrapper wrap(Register register) {
		return new RegisterWrapper(register);
	}

}