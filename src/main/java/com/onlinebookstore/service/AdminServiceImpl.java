package com.onlinebookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.AdminRepository;
import com.onlinebookstore.dto.Admin;

import com.onlinebookstore.exception.AdminException;
import com.onlinebookstore.exception.OrderException;

import net.bytebuddy.asm.Advice.This;
/************************************************************************************
 *          @author         Faisal khan
 *          Description      It is a service class that provides the services for Registering a new Admin, delete Admin,
 *          update Admin, get all Admins ,  login
 *          Version             1.0
 *          Created Date    16-AUG-2022
 ************************************************************************************/
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository adminRepository;

	/************************************************************************************
	 * Method: - Register Admin 
	 * Description: - Adding Admin
	 * @Object Admin - Details of Admin
	 * @returns String - Message that Admin Registered Successfully
	 * @throws AdminException - It is raised due to Admin details are invalid, or Admin
	 *                       id is not present.
	 ************************************************************************************/
	@Override
	public String registerAdmin(Admin admin) throws AdminException {
		String isRegistered ;
		List<Admin> adminList = this.adminRepository.findAll();
		if (!adminList.isEmpty()) {
			throw new AdminException("Admin already exists!");
		}
		else {
			this.adminRepository.save(admin);
			isRegistered="Admin registered Suceessfully";
		}
		return isRegistered;

	}
	/************************************************************************************
	 * Method: - Delete Admin 
	 * Description: - Deleting the Admin
	 * Parameter adminId - Unique Id of Admin
	 * Parameter Admin Password - Password of Admin
	 * @returns String - Message that Admin Deleted Successfully
	 * @throws AdminException - It is raised due to Admin details are invalid, or Admin
	 *                       id is not present.
	 ************************************************************************************/

	@Override
	public String deleteAdmin(Integer adminId, String adminPassword) throws AdminException {
		String isDeleted ;
		List<Admin> admin = this.adminRepository.findAll();
		if (admin.isEmpty()) {
			throw new AdminException("Admin does not exist for id " + adminId);
		}

		else {
			Admin first = admin.get(0);
			if (!first.getAdminPassword().equals(adminPassword)) {
				throw new AdminException("Incorrect Password");
			}

			adminRepository.delete(first);
			isDeleted = "Successful";
		}
		return isDeleted;
	}
	
	
	/************************************************************************************
	 * Method: - Update Admin 
	 * Description: - Updating details of  Admin
	 * @Object Admin - Details of Admin
	 * @returns String - Message that Admin Updated Successfully
	 * @throws AdminException - It is raised due to Admin details are invalid, or Admin
	 *                       id is not present.
	 ************************************************************************************/

	@Override
	public String updateAdmin(Admin admin) throws AdminException {
		String isUpdated;
		Optional<Admin> foundAdmin = this.adminRepository.findById(admin.getAdminId());
		if (foundAdmin.isEmpty()) {
			throw new AdminException("Admin doesnot exists for id " + admin.getAdminId());
		}
		else {
			this.adminRepository.save(admin);
			isUpdated="Admin Updated Successfully";
		}
		return isUpdated;}

	
	/************************************************************************************
	 * Method: - getAdmin 
	 * Description: - Getting/Fetching all Admins
	 * @returns List<Admin> - List of all Admins present
	 * @throws AdminException - It is raised due to Admin details are invalid, or Admin
	 *                       id is not present.
	 ************************************************************************************/
	@Override
	public List<Admin> getAdmin() throws AdminException {

		return this.adminRepository.findAll();
	}

	
	
	/************************************************************************************
	 * Method: - login 
	 * Description: - logging in Admin
	 * @Parameter adminId - Unique Id of Admin
	 * @Parameter adminPassword - Password of Admin
	 * @return Boolean - Return True or False if Admin able to login or not
	 * @throws AdminException - It is raised due to Admin details are invalid, or Admin
	 *                       id is not present.
	 ************************************************************************************/
	@Override
	public Boolean login(Integer adminId, String adminPassword) throws AdminException {
		boolean isLogedin=false;
		Optional<Admin> foundAdmin = this.adminRepository.findById(adminId);
		if (foundAdmin.isEmpty()) {
			throw new AdminException("Admin doesnot exists for id " + adminId);
		}
		if (!foundAdmin.get().getAdminPassword().equals(adminPassword)) {
			throw new AdminException("Incorrect password");
		}
		if (foundAdmin.get().getAdminPassword().equals(adminPassword)) {
			isLogedin=true;
		}
		return isLogedin;
	}

}
