package travel.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	
	private final String must_input = " �ʼ� �Է� �����Դϴ�.";
	private int num;

	@NotEmpty(message = "�̸���" + must_input)
	private String name;

	@NotNull(message = "���̸� �Է��ϼ���.")
	@Range(min = 10,max = 100,message = "10~100��� �ۼ��ؾ� �մϴ�.") //length �� ������ ������ ������ ���� ����� �Ұ��� �ϴ�
	private Integer age;

	@NotEmpty(message = "���������� 1�� �̻� �����ؾ� �մϴ�.")
	private String area;

	@NotBlank(message = "���ϴ� ���� Ÿ���� ������ �ּ���.")
	private String style;

	@NotBlank(message = "���ϴ� ���ݴ븦 �����ϼ���.")
	private String price;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
