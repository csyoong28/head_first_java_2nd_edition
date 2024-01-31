package soonyoong.headfirst.java;

import soonyoong.headfirst.java.model.Car;

import java.awt.Color;

class Mini extends Car {
	Color color;

	public Mini() {
		super();
		//this(Color.RED);	//this() must be the first statement in constrcuctor
	}

	/*public Mini(Color c) {
    //   super("Mini");		//super() must be the first statement in constrcuctor
       color = c;
       // more initialization
    }*/

	/*public Mini(int size) {
		this(Color.RED);
	//	super(size);

	}*/
}
