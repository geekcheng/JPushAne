package com.example.aslib
{
	import flash.events.Event;
	
	public class MyEvent extends Event
	{
		public var data:String = "";
		public function MyEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
	}
}