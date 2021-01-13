package com.koreait.fashionshop.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koreait.fashionshop.exception.LoginRequiredException;


//�븵�쑝濡� 濡쒓렇�씤�씠 �븘�슂�븳 �꽌鍮꾩뒪瑜� 泥섎━�븯湲� �쐞�븳 肄붾뱶�뒗, 而⑦듃濡ㅻ윭�뿉 �몢吏��븡怨�
//吏�湲� �씠 媛앹껜濡� 怨듯넻�솕�떆耳� AOP瑜� �쟻�슜�븯寃좊떎..
public class MemberSessionCheckAspect {
	private static final Logger logger = LoggerFactory.getLogger(MemberSessionCheckAspect.class);
	
	public Object sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		Object target = joinPoint.getTarget(); //�썝�옒 �샇異쒗븯�젮�뻽�뜕 媛앹껜
		logger.debug("�썝�옒 �샇異쒗븯�젮�뻽�뜕 媛앹껜�뒗 "+target);
		String methodName = joinPoint.getSignature().getName();
		logger.debug("�썝�옒 �샇異쒗븯�젮�뻽�뜕 硫붿꽌�뱶�뒗 "+methodName);
		Object[] args = joinPoint.getArgs(); //�썝�옒 �샇異쒗븯�젮�뻽�뜕 硫붿꽌�뱶�쓽 留ㅺ쾶蹂��닔
		
		//�쁽�옱�쓽 �슂泥��씠 �꽭�뀡�쓣 媛�吏�怨� �엳�뒗 吏�瑜� �뙋�떒�븯�뿬, �쟻�젅�븳 �젣�뼱..
		
		//�꽭�뀡�쓣 �뼸湲� �쐞�빐�꽌�뒗 HttpServletRequest媛� �븘�슂�븯�떎
		HttpServletRequest request = null;
		for(Object arg : args) {
			logger.debug("留ㅺ컻蹂��닔 紐낆� "+arg);
			if (arg instanceof HttpServletRequest) { //request媛앹껜�씪硫�..
				request = (HttpServletRequest)arg;
			}
		}
		
		//1. �꽭�뀡�씠 �뾾�떎硫�? �삁�쇅瑜� 諛쒖깮�떆�궗寃껋엫 --> ExceptionHandler瑜� 嫄곗퀜�꽌 �겢�씪�씠�뼵�듃�뿉寃� �쟻�젅�븳 �쓳�떟泥섎━..
		//2.�꽭�뀡�씠 �엳�떎硫�? 洹몃�濡� �썝�옒 �샇異쒗븯�젮 �뻽�뜕 硫붿꽌�뱶 吏꾪뻾..
		HttpSession session = null;
		session = request.getSession();
		Object result = null;
		
		if (session.getAttribute("member") == null) {
			throw new LoginRequiredException("濡쒓렇�씤�씠 �븘�슂�븳 �꽌鍮꾩뒪 �엯�땲�떎.");
		}else {
			//�썝�옒 �슂泥��쓽 �쓲由꾩쓣 洹몃�濡� 吏꾪뻾..
			//�썝�옒 �샇異쒗븯�젮�뻽�뜕 硫붿꽌�뱶瑜� ���떊 �샇異쒗빐以��떎.
			result = joinPoint.proceed(); //�뿬湲곗꽌 �삁�쇅媛� 諛쒖깮�븯誘�濡� �삁�쇅泥섎━�븯吏�留먭퀬 洹몃깷 throws!
		}
		
		
		return result;
	}
}
