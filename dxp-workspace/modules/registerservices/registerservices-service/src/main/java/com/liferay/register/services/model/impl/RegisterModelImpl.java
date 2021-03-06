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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.register.services.model.Register;
import com.liferay.register.services.model.RegisterModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Register service. Represents a row in the &quot;Register&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>RegisterModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RegisterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegisterImpl
 * @generated
 */
public class RegisterModelImpl
	extends BaseModelImpl<Register> implements RegisterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a register model instance should use the <code>Register</code> interface instead.
	 */
	public static final String TABLE_NAME = "Register";

	public static final Object[][] TABLE_COLUMNS = {
		{"rid", Types.BIGINT}, {"name", Types.VARCHAR},
		{"surname", Types.VARCHAR}, {"bdate", Types.TIMESTAMP},
		{"email", Types.VARCHAR}, {"regdate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("rid", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("surname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bdate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("regdate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Register (rid LONG not null primary key,name VARCHAR(75) null,surname VARCHAR(75) null,bdate DATE null,email VARCHAR(75) null,regdate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table Register";

	public static final String ORDER_BY_JPQL = " ORDER BY register.rid ASC";

	public static final String ORDER_BY_SQL = " ORDER BY Register.rid ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long RID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public RegisterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _rid;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Register.class;
	}

	@Override
	public String getModelClassName() {
		return Register.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Register, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Register, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Register, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Register)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Register, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Register, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Register)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Register, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Register, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Register>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Register.class.getClassLoader(), Register.class,
			ModelWrapper.class);

		try {
			Constructor<Register> constructor =
				(Constructor<Register>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Register, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Register, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Register, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Register, Object>>();
		Map<String, BiConsumer<Register, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Register, ?>>();

		attributeGetterFunctions.put("rid", Register::getRid);
		attributeSetterBiConsumers.put(
			"rid", (BiConsumer<Register, Long>)Register::setRid);
		attributeGetterFunctions.put("name", Register::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Register, String>)Register::setName);
		attributeGetterFunctions.put("surname", Register::getSurname);
		attributeSetterBiConsumers.put(
			"surname", (BiConsumer<Register, String>)Register::setSurname);
		attributeGetterFunctions.put("bdate", Register::getBdate);
		attributeSetterBiConsumers.put(
			"bdate", (BiConsumer<Register, Date>)Register::setBdate);
		attributeGetterFunctions.put("email", Register::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<Register, String>)Register::setEmail);
		attributeGetterFunctions.put("regdate", Register::getRegdate);
		attributeSetterBiConsumers.put(
			"regdate", (BiConsumer<Register, Date>)Register::setRegdate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getRid() {
		return _rid;
	}

	@Override
	public void setRid(long rid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_rid = rid;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@Override
	public String getSurname() {
		if (_surname == null) {
			return "";
		}
		else {
			return _surname;
		}
	}

	@Override
	public void setSurname(String surname) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_surname = surname;
	}

	@Override
	public Date getBdate() {
		return _bdate;
	}

	@Override
	public void setBdate(Date bdate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_bdate = bdate;
	}

	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_email = email;
	}

	@Override
	public Date getRegdate() {
		return _regdate;
	}

	@Override
	public void setRegdate(Date regdate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_regdate = regdate;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Register.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Register toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Register>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RegisterImpl registerImpl = new RegisterImpl();

		registerImpl.setRid(getRid());
		registerImpl.setName(getName());
		registerImpl.setSurname(getSurname());
		registerImpl.setBdate(getBdate());
		registerImpl.setEmail(getEmail());
		registerImpl.setRegdate(getRegdate());

		registerImpl.resetOriginalValues();

		return registerImpl;
	}

	@Override
	public int compareTo(Register register) {
		long primaryKey = register.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Register)) {
			return false;
		}

		Register register = (Register)object;

		long primaryKey = register.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Register> toCacheModel() {
		RegisterCacheModel registerCacheModel = new RegisterCacheModel();

		registerCacheModel.rid = getRid();

		registerCacheModel.name = getName();

		String name = registerCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			registerCacheModel.name = null;
		}

		registerCacheModel.surname = getSurname();

		String surname = registerCacheModel.surname;

		if ((surname != null) && (surname.length() == 0)) {
			registerCacheModel.surname = null;
		}

		Date bdate = getBdate();

		if (bdate != null) {
			registerCacheModel.bdate = bdate.getTime();
		}
		else {
			registerCacheModel.bdate = Long.MIN_VALUE;
		}

		registerCacheModel.email = getEmail();

		String email = registerCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			registerCacheModel.email = null;
		}

		Date regdate = getRegdate();

		if (regdate != null) {
			registerCacheModel.regdate = regdate.getTime();
		}
		else {
			registerCacheModel.regdate = Long.MIN_VALUE;
		}

		return registerCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Register, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Register, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Register, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Register)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Register, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Register, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Register, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Register)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Register>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _rid;
	private String _name;
	private String _surname;
	private Date _bdate;
	private String _email;
	private Date _regdate;

	public <T> T getColumnValue(String columnName) {
		Function<Register, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Register)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("rid", _rid);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("surname", _surname);
		_columnOriginalValues.put("bdate", _bdate);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("regdate", _regdate);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("rid", 1L);

		columnBitmasks.put("name", 2L);

		columnBitmasks.put("surname", 4L);

		columnBitmasks.put("bdate", 8L);

		columnBitmasks.put("email", 16L);

		columnBitmasks.put("regdate", 32L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Register _escapedModel;

}