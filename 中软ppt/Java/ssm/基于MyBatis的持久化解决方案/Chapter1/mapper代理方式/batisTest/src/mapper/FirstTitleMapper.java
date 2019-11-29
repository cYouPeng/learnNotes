package mapper;

import java.util.List;

import entity.FirstTitle;

public interface FirstTitleMapper {

	public FirstTitle selectFirstTitleById(int fid);
	public List selectFirstTitleAll();
	public List selectFirstTitleByAll(FirstTitle ft);
	public List selectFirstTitleByLike(String titleName);
	public List selectFirstTitleByLikeAll(FirstTitle ft);
	public void insertFirstTitle(FirstTitle ft);
	public void updateFirstTitle(FirstTitle ft);
	public void deleteFirstTitleById(int fid);
	public int selectFirstTitleByCount();
	public int insertFirsttitleBatch(List list);
	public int updateFirsttitleBatch(List list);
	public int deleteFirstTitleBatch(int[] fid);
	
}
