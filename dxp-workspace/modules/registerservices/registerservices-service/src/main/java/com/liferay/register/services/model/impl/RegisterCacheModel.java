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

package com.liferay.register.services.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.register.services.model.Register;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Register in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RegisterCacheModel
	implements CacheModel<Register>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RegisterCacheModel)) {
			return false;
		}

		RegisterCacheModel registerCacheModel = (RegisterCacheModel)object;

		if (rid == registerCacheModel.rid) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, rid);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{rid=");
		sb.append(rid);
		sb.append(", name=");
		sb.append(name);
		sb.append(", surname=");
		sb.append(surname);
		sb.append(", bdate=");
		sb.append(bdate);
		sb.append(", email=");
		sb.append(email);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Register toEntityModel() {
		RegisterImpl registerImpl = new RegisterImpl();

		registerImpl.setRid(rid);

		if (name == null) {
			registerImpl.setName("");
		}
		else {
			registerImpl.setName(name);
		}

		if (surname == null) {
			registerImpl.setSurname("");
		}
		else {
			registerImpl.setSurname(surname);
		}

		if (bdate == Long.MIN_VALUE) {
			registerImpl.setBdate(null);
		}
		else {
			registerImpl.setBdate(new Date(bdate));
		}

		if (email == null) {
			registerImpl.setEmail("");
		}
		else {
			registerImpl.setEmail(email);
		}

		registerImpl.resetOriginalValues();

		return registerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		rid = objectInput.readLong();
		name = objectInput.readUTF();
		surname = objectInput.readUTF();
		bdate = objectInput.readLong();
		email = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(rid);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (surname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(surname);
		}

		objectOutput.writeLong(bdate);

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}
	}

	public long rid;
	public String name;
	public String surname;
	public long bdate;
	public String email;

}