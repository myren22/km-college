
public class QueueExample {
	public static Queue<Candy> getCandy(Queue<Candy> dispenser, int day){
		Queue<Candy> orderConsumed = new Queue<Candy>();
		
		
		//Monday
			//On Mondays she eats them one by one in the order they come out from the  dispenser
		if(day==0){
			while(!dispenser.isEmpty()){
				orderConsumed.enqueue(dispenser.dequeue());
			}
			return orderConsumed;
		}
		//Tuesday she eats one candy and adds the next candy back to the bottom of the dispenser
		else if(day==1){
			while(!dispenser.isEmpty()){
				orderConsumed.enqueue(dispenser.dequeue());
				if(!dispenser.isEmpty()){
					dispenser.enqueue(dispenser.dequeue());
				}
			}
			return orderConsumed;
		}
		//Wednesdays, she eats one candy and adds the next two back to the bottom of the dispenser  (in the same order they were taken off).
		else if(day==2){
			while(!dispenser.isEmpty()){
				orderConsumed.enqueue(dispenser.dequeue());
				if(!dispenser.isEmpty()){
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
				}
			}
			return orderConsumed;
		}
		//Thursday she eats one candy and puts back at the bottom of the  dispenser the next 3 candies
		else if(3==day && day<= 5){
			while(!dispenser.isEmpty()){
				orderConsumed.enqueue(dispenser.dequeue());
				if(!dispenser.isEmpty()){
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
				}
			}
			return orderConsumed;
		}
		//Friday
		else if(4==day){
			while(!dispenser.isEmpty()){
				orderConsumed.enqueue(dispenser.dequeue());
				if(!dispenser.isEmpty()){
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
				}
			}
			return orderConsumed;
		}
		//Saturday
		else if(5==day){
			while(!dispenser.isEmpty()){
				orderConsumed.enqueue(dispenser.dequeue());
				if(!dispenser.isEmpty()){
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
				}
			}
			return orderConsumed;
		}
		//Sunday she eats one candy and puts back the next 6 candies
		else{
			while(!dispenser.isEmpty()){
				orderConsumed.enqueue(dispenser.dequeue());
				if(!dispenser.isEmpty()){
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
					dispenser.enqueue(dispenser.dequeue());
				}
			}
			return orderConsumed;
		}
	}
}
