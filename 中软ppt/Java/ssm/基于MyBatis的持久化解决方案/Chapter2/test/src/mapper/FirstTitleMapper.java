package mapper;

import java.util.List;

import entity.FirstTitle;

public interface FirstTitleMapper {

	public FirstTitle selectFirstTitleById(int fid);
	public List selectFirstTitleAll();
	public List selectFirstTitleAllByLazy();
	public void updateFirstTitle(FirstTitle ft);
	
}
