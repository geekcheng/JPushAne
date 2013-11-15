package com.example.aslib
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;

	public class AndroidLib extends EventDispatcher
	{
		public var extCtx:ExtensionContext=null;
		public function AndroidLib()
		{
			extCtx = ExtensionContext.createExtensionContext("com.example.myextension","");
			extCtx.addEventListener(StatusEvent.STATUS,onRecv);
		}
		
		private function onRecv(event:StatusEvent):void{
			var code:String = event.code;
			if(code == "onOpen"){
				var openEvent:MyEvent = new MyEvent("onOpened");
				openEvent.data = event.level;
				dispatchEvent(openEvent);
			}else if(code == "recv_notify"){
				var notifyEvent:MyEvent = new MyEvent("onNotify");
				notifyEvent.data = event.level;
				dispatchEvent(notifyEvent);
			}else if(code == "recv_msg"){
				var msgEvent:MyEvent = new MyEvent("onMsg");
				msgEvent.data = event.level;
				dispatchEvent(msgEvent);
			}else{
			//
			}
		}
		public function initjpush():void{
			if(extCtx){
				extCtx.call("init");
			}
		}
		public function regrecv():void{
			if(extCtx){
				extCtx.call("reg");
			}
		}
		public function setAlias(alias:String):void{
			//可以在这里验证一下alias的合法性
			if(extCtx){
				extCtx.call("set_alias",alias);
			}
		}
		public function setTags(tags:Array):void{
			//可以在这里验证tags的合法性
			if(extCtx){
				extCtx.call("set_tags",tags.toString());
			}
		}
		public function showToast(msg:String):void{
			if(extCtx){
				extCtx.call("toast",msg);
			}
		}
	}
}