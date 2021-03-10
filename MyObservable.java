public class MyObservable{

	MyObserver[] observers = new MyObserver[10];
	boolean change = false;
	int count = 0;

	public void addObserver(MyObserver o){
		myObservers[count] = o;
		count++;
	}

	public int countObservers(){
		return count;
	}
	
	protected void setChanged(){
		change = true;	
	}

	public boolean hasChanged(){
		return change;
	}
	
	protected void clearChanged(){
		change = false;
	}

	public void notifyObservers(){
		
		if(change==true)
			update(this.MyObservable,"has pooped!");
		
		clearChanged();
	}

	public void notifyObservers(Object arg){
		
		if(change == true)
		
		for(int i = 0; observers.length; i++))
			observers[i].update(this, arg);
		
		clearChanged();
	}
}