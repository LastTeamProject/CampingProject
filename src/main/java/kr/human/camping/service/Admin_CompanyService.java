package kr.human.camping.service;

import kr.human.camping.vo.CompanyVO;
import kr.human.camping.vo.PagingVO;

public interface Admin_CompanyService {
	// 목록보기
	PagingVO<CompanyVO> selectList(int currentPage, int pageSize, int blockSize);
	// 1개 내용보기
	CompanyVO selectByIdx(int idx);
	// 저장하기
	void insert(CompanyVO companyVO);
	// 수정하기
	void update(CompanyVO companyVO);
	// 삭제하기
	void delete(CompanyVO companyVO);
}
