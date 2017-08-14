/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author S2026055
 */
public class FileReader1 {



    /**
     *
     * @param args
     * @throws IOExceptions
     * @throws FileNotFoundException
     * @throws IOException
     */
 public static void main(String[]args) throws IOExceptions,FileNotFoundException,IOException{
List<Employee> access = new ArrayList<>();
  
    BufferedReader reader;
    Employee employees = null;
    
    
    reader = new BufferedReader(new FileReader("D:\\Users\\S2026055\\Desktop\\access.txt"));
    String line;

    while ((line = reader.readLine()) != null) {
        //System.out.println(line);
        String[] num = line.split("\t");
        employees = new Employee(num[0],num[1],num[2],num[3]);
       access.add (employees);
               
     
    //empEmployee = new Employee  (num[0],num[1],num[2])  
    //System.out.println(line);
    }
    
    Comparator<Employee> byJobId = Comparator.comparing(Employee::getJobid); 
         //Collections.sort(employees, byOrgUnit);
         Collections.sort(access, byJobId);
         
         final AtomicInteger count = new AtomicInteger();
        access.stream()
               //.sorted(comparing(EMP::getAmount).reversed())
                .limit(1000)
               .forEach(e -> 
                System.out.printf("%5d\t%s%n", count.incrementAndGet(), e.toString())
               );

   }
}
  

