package com.myn.aspect_test;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @Author Yogesh.Manware
 *
 */

@Component
public class DoBusiness {

	@Pointcut
	public ResponseData work(RequestData requestData) {
		ResponseData rd = new ResponseData();
		rd.setF1Resp(requestData.getF1() + "[Through Work()]");
		rd.setF2Resp(requestData.getF2());

		return rd;
	}

	@Pointcut
	public ResponseData simpleWork() {
		ResponseData rd = new ResponseData();
		rd.setF1Resp("[Through Work()]");
		rd.setF2Resp(101L);

		return rd;
	}

	@Pointcut
	public ResponseData workForAround(RequestData requestData) {
		ResponseData rd = new ResponseData();
		rd.setF1Resp(requestData.getF1() + "[Through WorkForAround()]");
		rd.setF2Resp(200L);

		return rd;
	}

	@Pointcut
	public ResponseData workWhichthrowsException(RequestData requestData) throws RuntimeException {
		ResponseData rd = new ResponseData();
		rd.setF1Resp(requestData.getF1() + "[Through WorkForAround()]");
		rd.setF2Resp(200L);

		if (true) {
			throw new RuntimeException("TEST RE");
		}
		return rd;
	}

	@Pointcut
	public List<ResponseData> workForLoop() {
		List<ResponseData> resps = new ArrayList<ResponseData>();

		for (Long i = (long) 0; i < 5; i++) {
			RequestData rd = new RequestData();
			rd.setF1("TEST " + i);
			rd.setF2(i);
			ResponseData response = this.workWhichthrowsException(rd);
			System.out.println("Advice applied as: " + response.getF1Resp());

			resps.add(response);
		}
		return resps;
	}

}
