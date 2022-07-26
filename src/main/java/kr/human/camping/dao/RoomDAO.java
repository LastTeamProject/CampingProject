package kr.human.camping.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.human.camping.vo.RoomVO;

@Mapper
public interface RoomDAO {
	// 전체 개수 구하기
	int selectRoomnCount() throws SQLException;
	// 방 1개 보기
	RoomVO selectRoom(int roomidx) throws SQLException;
	// 방 추가
	void insertRoom(RoomVO roomVO) throws SQLException;
	// 방 삭제
	void deletetRoom(RoomVO roomVO) throws SQLException;
	// 방 r_check 변경하기
	void updateCheck(int roomidx) throws SQLException;
	// 등록된 모든 방 보기
	List<RoomVO> selectRoomList() throws SQLException;
}
