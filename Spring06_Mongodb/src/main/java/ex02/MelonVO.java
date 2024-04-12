package ex02;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "melon")
public class MelonVO {

	private String id;
	private String rank; // ����
	private String title; // �뷡 ����
	private String singer; // ����
	private String albumImage; // �ٹ� �̹���
}
