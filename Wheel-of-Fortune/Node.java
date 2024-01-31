
public class Node {
	
	private Object data;
	private Object data2;
	private Node link;
	
	
	public Node(Object data) {
		
		this.data = data;
		this.link = null;
	}
	public Node(Object data,Object data2) {
		
		this.data = data;
		this.data2 = data2;
		this.link = null;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link = link;
	}
	public Object getData2() {
		return data2;
	}
	public void setData2(Object data2) {
		this.data2 = data2;
	}
	
	
	

}
