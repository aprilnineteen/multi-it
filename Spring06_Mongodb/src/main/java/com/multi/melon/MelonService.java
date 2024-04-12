package com.multi.melon;

import java.util.List;

public interface MelonService {

	// ��� ��Ʈ �뷡 ����Ʈ ���� �Լ�
	int collectMelonList() throws Exception;
	
	// ������ ��� �뷡 ����Ʈ
	List<MelonVO> getSongList() throws Exception;
	
	// ������ �뷡�� ��������
	List<SumVO> getSingerSongCount() throws Exception;

}