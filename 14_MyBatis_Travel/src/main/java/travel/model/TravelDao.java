package travel.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utility.Paging;

@Service("myTravelDao") //Service �� �����ϰ� Component �� �����ϴ�.
public class TravelDao {
	
	private String namespace = "travel.TravelBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<TravelBean> getTravel(Paging pageInfo, Map<String, String> map) {
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		
		// p1 => 0,2 / p2 => 2,2 / p3 => 4,2 �� ���·� RowBouds ��ü �����.
		
		List<TravelBean> lists = sqlSessionTemplate.selectList(namespace + ".getTravel", map, rowBounds);
		
		System.out.println("getTravel : " + lists.size());
		
		return lists;
	}

	public int InsertTravel(TravelBean tb) {
		
		int cnt = sqlSessionTemplate.insert(namespace + ".InsertTravel",tb);
		
		System.out.println("InsertTravel : " + cnt);
		
		return cnt;
	}

	public int DeleteTravel(int num) {
		
		int cnt = sqlSessionTemplate.delete(namespace + ".DeleteTravel", num);
		
		System.out.println("DeleteTravel : " + cnt);
		
		return cnt;
	}

	public TravelBean getoneTravel(int num) {
		
		TravelBean tb = sqlSessionTemplate.selectOne(namespace + ".getoneTravel", num);
		
		System.out.println("getoneTravel : " + tb.getNum());
		
		return tb;
	}

	public int UpdateTravel(TravelBean tb) {
		
		int cnt = sqlSessionTemplate.update(namespace + ".UpdateTravel", tb);
		
		System.out.println("UpdateTravel : " + cnt);
		
		return cnt;
	}

	public int getTotalCount(Map<String,String> map) {
		
		int cnt = sqlSessionTemplate.selectOne(namespace + ".getTotalCount", map);
		
		return cnt;
	}
	
}
