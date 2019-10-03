
public class ListExample {
	public static Node<Character> getUppercaseList(Node<Character> head){
		Node<Character> resultHead = null;
		Node<Character> now = head;
		Node<Character> previous = null;
		while(now != null){
			
			if(Character.isUpperCase(now.value)){
				if(resultHead==null){
					resultHead=now;
					previous=now;
				}
				else{
					previous.next=now;
					previous = now;
				}
			}
			
			
			now= now.next;
		}
		if(previous!=null){
			if(previous.next!=null && Character.isLowerCase(previous.next.value)){
				previous.next=null;
			}
		}
		return resultHead;
	}
}
