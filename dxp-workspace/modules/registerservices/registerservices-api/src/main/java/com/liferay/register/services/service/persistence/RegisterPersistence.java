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

package com.liferay.register.services.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.register.services.exception.NoSuchRegisterException;
import com.liferay.register.services.model.Register;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the register service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegisterUtil
 * @generated
 */
@ProviderType
public interface RegisterPersistence extends BasePersistence<Register> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegisterUtil} to access the register persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the register in the entity cache if it is enabled.
	 *
	 * @param register the register
	 */
	public void cacheResult(Register register);

	/**
	 * Caches the registers in the entity cache if it is enabled.
	 *
	 * @param registers the registers
	 */
	public void cacheResult(java.util.List<Register> registers);

	/**
	 * Creates a new register with the primary key. Does not add the register to the database.
	 *
	 * @param rid the primary key for the new register
	 * @return the new register
	 */
	public Register create(long rid);

	/**
	 * Removes the register with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rid the primary key of the register
	 * @return the register that was removed
	 * @throws NoSuchRegisterException if a register with the primary key could not be found
	 */
	public Register remove(long rid) throws NoSuchRegisterException;

	public Register updateImpl(Register register);

	/**
	 * Returns the register with the primary key or throws a <code>NoSuchRegisterException</code> if it could not be found.
	 *
	 * @param rid the primary key of the register
	 * @return the register
	 * @throws NoSuchRegisterException if a register with the primary key could not be found
	 */
	public Register findByPrimaryKey(long rid) throws NoSuchRegisterException;

	/**
	 * Returns the register with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rid the primary key of the register
	 * @return the register, or <code>null</code> if a register with the primary key could not be found
	 */
	public Register fetchByPrimaryKey(long rid);

	/**
	 * Returns all the registers.
	 *
	 * @return the registers
	 */
	public java.util.List<Register> findAll();

	/**
	 * Returns a range of all the registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registers
	 * @param end the upper bound of the range of registers (not inclusive)
	 * @return the range of registers
	 */
	public java.util.List<Register> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registers
	 * @param end the upper bound of the range of registers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of registers
	 */
	public java.util.List<Register> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Register>
			orderByComparator);

	/**
	 * Returns an ordered range of all the registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registers
	 * @param end the upper bound of the range of registers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of registers
	 */
	public java.util.List<Register> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Register>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the registers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of registers.
	 *
	 * @return the number of registers
	 */
	public int countAll();

}