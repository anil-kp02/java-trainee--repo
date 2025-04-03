package com.spring.role.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.role.dao.EmployeeDao;
import com.spring.role.entity.Employee;
import com.spring.role.entity.Role;
import com.spring.role.entity.RoleType;

import jakarta.transaction.Transactional;

@Service
public class ExcelService {

	@Autowired
	private EmployeeDao dao;

	@Transactional
    public String processExcelFile(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Read first sheet
            List<Employee> employees = new ArrayList<>();

            int rowIndex = 0;
            for (Row row : sheet) {
                if (rowIndex == 0) { // Skip header row
                    rowIndex++;
                    continue;
                }

                Employee employee = new Employee();
                employee.setId((long) row.getCell(0).getNumericCellValue());
                employee.setName(row.getCell(1).getStringCellValue());
                employee.setEmail(row.getCell(2).getStringCellValue());

                // If Roles are comma-separated
                String[] rolesArray = row.getCell(3).getStringCellValue().split(",");
                Set<Role> roles = new HashSet<>();
                for (String role : rolesArray) {
                    Role roleEntity = new Role();
                    roleEntity.setName(RoleType.valueOf(role.trim().toUpperCase())); // Convert to Enum
                    roles.add(roleEntity);
                }
                employee.setRoles(roles);

               /* employee.setAddresses(List.of(row.getCell(4).getStringCellValue()));*/
                dao.save(employee);

                employees.add(employee);
            }

            // Save all employees to the database
          // dao.saveAll(employees);
            return "Excel file processed successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing Excel file: " + e.getMessage();
        }
    }
