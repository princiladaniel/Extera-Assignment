package learnRetry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import util.DynamicData;

public class RetryListener implements IRetryAnalyzer,IAnnotationTransformer{
int count=0;

	public boolean retry(ITestResult result) {
		if(count<2) {
			count++;
			return true;
			
		}
		return false;
	}
	public void transform( ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		    // not implemented
	       annotation.setRetryAnalyzer(RetryListener.class);

		  }

}
