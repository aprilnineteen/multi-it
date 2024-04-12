package ex02;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "melon")
public class MelonVO {

	private String id;
	private String rank; // 순위
	private String title; // 노래 제목
	private String singer; // 가수
	private String albumImage; // 앨범 이미지
}
