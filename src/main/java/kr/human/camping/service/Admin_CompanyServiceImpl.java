package kr.human.camping.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.human.camping.dao.Admin_CompanyDAO;
import kr.human.camping.vo.CompanyVO;
import kr.human.camping.vo.PagingVO;

@Service("Admin_CompanyService")
@Transactional
public class Admin_CompanyServiceImpl  implements Admin_CompanyService{

	@Autowired
	private Admin_CompanyDAO admin_CompanyDAO;

	@Override
	public PagingVO<CompanyVO> selectList(int currentPage, int pageSize, int blockSize) {
		PagingVO<CompanyVO> pagingVO = null;
		try {
			int totalCount = admin_CompanyDAO.selectCompanyCount();
			pagingVO = new PagingVO<>(totalCount, currentPage, pageSize, blockSize);
			HashMap<String, Integer> hashMap = new HashMap<>();
			hashMap.put("startNo", pagingVO.getStartNo());
			hashMap.put("endNo", pagingVO.getPageSize());
			List<CompanyVO> list = admin_CompanyDAO.selectList(hashMap);
			pagingVO.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pagingVO;
	}

	@Override
	public CompanyVO selectByIdx(int idx) {
		CompanyVO companyVO= null;
		try {
			companyVO = admin_CompanyDAO.selectByIdx(idx);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return companyVO;
	}

	@Override
	public void insert(CompanyVO companyVO) {
		if(companyVO!=null) {
			try {
				admin_CompanyDAO.insert(companyVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(CompanyVO companyVO) {
		if(companyVO!=null) {
			try {
				CompanyVO dbVO = admin_CompanyDAO.selectByIdx(companyVO.getIdx()); // DB에서 원본 가져오기
				admin_CompanyDAO.update(companyVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(CompanyVO companyVO) {
		if(companyVO!=null) {
			try {
				CompanyVO dbVO = admin_CompanyDAO.selectByIdx(companyVO.getIdx()); // DB에서 원본 가져오기
				admin_CompanyDAO.delete(companyVO.getIdx());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
