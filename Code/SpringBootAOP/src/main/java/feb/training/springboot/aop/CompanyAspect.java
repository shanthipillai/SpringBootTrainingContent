package feb.training.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import feb.training.springboot.dto.EmployeeClientDTO;
@Aspect
@Component
public class CompanyAspect {
	
	/*
	 * @Before("execution(* feb.training.springboot.service.*.*(..))") public void
	 * processbeforelog(org.aspectj.lang.JoinPoint jointpoint) {
	 * 
	 * String methodname=jointpoint.getSignature().getName(); String
	 * classname=jointpoint.getSignature().getDeclaringTypeName();
	 * System.out.println("Before AOP execution In "+classname+""+
	 * methodname+" is executed"); }
	 * 
	 * 
	 * 
	 * @After("execution(* feb.training.springboot.service.*.*(..))") public void
	 * processafterlog(org.aspectj.lang.JoinPoint jointpoint) {
	 * 
	 * String methodname=jointpoint.getSignature().getName(); String
	 * classname=jointpoint.getSignature().getDeclaringTypeName();
	 * System.out.println("After AOP execution In "+classname+""+
	 * methodname+" is executed"); }
	 */
	 
	 
	
	/*
	 * @AfterReturning( pointcut = "execution(* com.training.service.*.*(..))",
	 * returning = "result" )
	 */
	 
	/*
	 * @AfterReturning(value="execution(* feb.training.springboot.service.*.*(..))",
	 * returning="result")
	 * 
	 * public void afterReturn(Object result) {
	 * System.out.println("Method has return: " + result);
	 * 
	 * }
	 */
	 
	  
	  
		/*
		 * @Pointcut("execution(* feb.training.springboot.service.*.*(..))") public void
		 * serviceMethods() {}
		 * 
		 * 
		 * @Around("serviceMethods()") public Object beforeafter(ProceedingJoinPoint
		 * psp) throws Throwable {
		 * System.out.println("Before"+psp.getSignature().getName()); Object
		 * result=psp.proceed();
		 * System.out.println("After"+psp.getSignature().getName());
		 * System.out.println(result); return result; }
		 */
	
	
	
		
		  @Around("execution(* feb.training.springboot.service.*.*(..))") 
		  public Object modifyBasedOnReturnType(ProceedingJoinPoint pjp) throws Throwable {
		  
		  Object result = pjp.proceed(); // call actual method
		  
		  // 🔍 Handle your specific DTO 
		  if (result instanceof EmployeeClientDTO) {
		  
		  EmployeeClientDTO dto = (EmployeeClientDTO) result;
		  
		  // 🔥 Modify fields dto.setEmpemail(dto.getEmpemail() + " [AOP]");
		  dto.setClientemail(dto.getClientemail() + " [AOP]");
		  
		  dto.setBilling(dto.getBilling() + 500);
		  
		  // Business logic
		  if (dto.getCompanyexp() > 5) {
		  
		  
		  dto.setPrjctname(dto.getPrjctname() + " (Senior)"); }
		  else {
		  dto.setPrjctname(dto.getPrjctname() + " (Junior)"); }
		  
		  result = dto; 
		  
		  
		  
		  }
		return result;
		  }
		 
	  
	  
			/*
			 * @AfterThrowing( value =
			 * "execution(* feb.training.springboot.service.*.*(..))", throwing = "ex" )
			 * public void handleException(JoinPoint jp, Exception ex) {
			 * 
			 * System.out.println("❌ Exception in method: " + jp.getSignature().getName());
			 * System.out.println("❌ Error: " + ex.getMessage()); }
			 */
	 
}
