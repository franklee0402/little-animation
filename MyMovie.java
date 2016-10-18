package animation;
public class MyMovie {
	public static void main(String args[]){

		Animation s = new Animation(1024, 768);
		s.setFrameRate(10);
		s.setBackgroundImage("background.png");//set background.
		
		//set up sprite
		Sprite mario1 = new Sprite("mario1.png");//stand
		mario1.setSize(127,174);
		Sprite mario2 = new Sprite("mario2.png");//walk
		mario2.setSize(123,166);
		Sprite mario3 = new Sprite("mario3.png");//jump
		mario3.setSize(112,173);
		Sprite mario4 = new Sprite("mario4.png");
		mario4.setSize(108,180);
		Sprite stomp1 = new Sprite("stomp1.png");//shock
		stomp1.setSize(158,192);
		Sprite GameOver = new Sprite("GameOver.png");
		GameOver.setSize(172,149);
		//bowser
		Sprite bowser = new Sprite("bowser.png");
		bowser.setSize(103,104);
		Sprite bowser2 = new Sprite("bowser2.png");//fire
		bowser2.setSize(132,83);
		//block
		Sprite block = new Sprite("block.png");//?
		block.setSize(62, 63);
		Sprite block1 = new Sprite("block1.png");
		block1.setSize(62,63);
		//cloud
		Sprite cloud = new Sprite("cloud.png");
		cloud.setSize(156,101);
		//koopa
		Sprite koopa = new Sprite("koopa.png");//walk to the left
		koopa.setSize(70,90);
		Sprite koopa2 = new Sprite("koopa2.png");//walk to the right
		koopa2.setSize(70,90);
		//mushroom
		Sprite mushroom = new Sprite ("mushroom.png");
		mushroom.setSize(65,65);
		
		
		int x = 30;
		double y = Math.pow(x,1.01);
		double posCloud = 50 ;
		boolean right = true;
		
		s.addSprite(mario1);//adds the above sprite "s" to the animation to be displayed
		mario1.setPosition(30,53);//sets the position of the Sprite in the Animation window
		s.frameFinished();//save the changes made to the Sprite/Animation
		//s.removeSprite(mario1);
		
		s.addSprite(cloud);
		cloud.setPosition(x/10,(int)Math.cos(x)+800);
		s.frameFinished();
		s.removeSprite(cloud);
		
		s.addSprite(koopa2);
		koopa2.setPosition(900,360);
		s.frameFinished();
		
		for(x = 30; x != -1; x +=10){
			
			//mario
			s.addSprite(mario1);
			mario1.setPosition(x, 53);
			s.frameFinished();
			s.removeSprite(mario1);
			
			s.addSprite(mario2);
			mario2.setPosition(x, 53);
			s.frameFinished();
			s.removeSprite(mario2);
			
			//bottom turtle
			
			
			posCloud++;
			//cloud
			s.addSprite(cloud);
			cloud.setPosition((int)(50*Math.cos(posCloud*0.4)+80),460);
				
			//koopa
			if(right == true){
				s.removeSprite(koopa);
				s.addSprite(koopa2);
				koopa2.setPosition((int)(50*Math.cos(posCloud*0.2)+910),360);
				
				if(50*Math.cos(posCloud*0.2) >= 49){
					s.removeSprite(koopa2);
					s.addSprite(koopa);
					koopa.setPosition((int)(50*Math.cos(posCloud*0.2)+910),360);

					right = false;
				}
			}if (right == false){
				s.removeSprite(koopa2);
				s.addSprite(koopa);
				koopa.setPosition((int)(50*Math.cos(posCloud*0.2)+910),360);
				
					if (50*Math.cos(posCloud*0.2) <= -49){
						s.removeSprite(koopa);
						s.addSprite(koopa2);
						koopa2.setPosition((int)(50*Math.cos(posCloud*0.2)+910),360);
						right = true;
					}
			}
			
			if(x == 560){
				for(x = 560; x <660; x += 10){
					s.addSprite(mario3);
					y = ((-30*Math.pow(x-560,2))/4000)+135;
					mario3.setPosition(x, (int)y);
					s.frameFinished();
					s.removeSprite(mario3);
					
					
					//mario starts to jump.
					if (x == 570){	
						for (int shake = 1; shake <10; shake++ ){
							//block shaking
							double yBlock = 244+ Math.cos(10*shake)*15;
							s.addSprite(mario3);
							s.addSprite(block);
							block.setPosition(618, (int)yBlock);
							s.frameFinished();
							s.removeSprite(block);
							}
						
						//mushroom
						s.addSprite(mushroom);
						mushroom.setPosition(615, 250);
						for (int shroom = 1; shroom < 30; shroom++){
							
							if (shroom <3){
								s.addSprite(mushroom);//come out
								mushroom.setPosition(615,257+shroom*20);
								s.frameFinished();
								s.removeSprite(mushroom);
								
								s.addSprite(mushroom);
								mushroom.setPosition(625,257+shroom*20);
								s.frameFinished();
								s.removeSprite(mushroom);
							}else if (shroom>3 && shroom <=5){
								s.addSprite(mushroom);//on top
								mushroom.setPosition(615-shroom*20,295);
								s.frameFinished();
								s.removeSprite(mushroom);
							}else if (shroom >5 && shroom<= 12){
								s.addSprite(mushroom);//falling
								mushroom.setPosition(545-shroom*7,295-shroom*20);
								s.frameFinished();
								s.removeSprite(mushroom);
							}else if (shroom >12 && shroom <= 25){
								try{
									Thread.sleep(10);
								}catch(InterruptedException ex){
									
								}
									s.addSprite(mushroom);//slide
									mushroom.setPosition(485-shroom*14,55);
									s.frameFinished();
									s.removeSprite(mushroom);
									
									s.addSprite(bowser);
									bowser.setPosition(50, 30+shroom);
									bowser.setSize(202,204);
							}else if (shroom >25 && shroom <= 30){
								try{
									Thread.sleep(400);
								}catch(InterruptedException ex){
									
								}
									//bowser comes out
									s.addSprite(bowser);
									bowser.setPosition(50, 20);
									bowser.setSize(101*shroom/6,102*shroom/6);
									bowser2.setSize(101*shroom/6,102*shroom/6);
									s.frameFinished();
									//s.removeSprite(bowser);
							}
							
						
							
							
						}
						s.addSprite(block1);
						block1.setPosition(618,244);
					}
					
				}
				
			}
			
			if (x == 670){
				s.addSprite(mario4);
				mario4.setPosition(670,45);
				s.frameFinished();
				s.removeSprite(mario4);
				try{
					Thread.sleep(4000);
				}catch(InterruptedException ex){
					
				}
				s.addSprite(bowser);
				bowser.setPosition(50, 35);
				s.frameFinished();
				s.removeSprite(bowser);
				
			}
		
			//bowser show time.
			if (x == 680){
				for (x = 680; x < 740; x+= 10 ){										
					s.addSprite(bowser2);
					bowser2.setPosition(50+x*1/3, 5);
					s.frameFinished();
					
					s.addSprite(stomp1);
					stomp1.setPosition(x,33);
					s.frameFinished();
					s.removeSprite(stomp1);
					
					s.addSprite(mario2);
					mario2.setPosition(x+10, 53);
					s.frameFinished();
					s.removeSprite(mario2);
					
				}
			}
			if (x == 740){
				s.removeSprite(bowser2);
				
				s.addSprite(bowser);
				bowser.setPosition(200,20);
				s.frameFinished();
				
				s.addSprite(GameOver);
				GameOver.setPosition(x,28);
				s.frameFinished();
				try{
					Thread.sleep(3000);
				}catch(InterruptedException ex){
				}
				
				x = 1100;
			}
			if(x == 1150){
				s.removeSprite(GameOver);
				s.removeSprite(bowser);
				s.addSprite(mario1);
				s.addSprite(block);
				block.setPosition(618, 244);
				mario1.setPosition(30,53);
				x = 30;
			}
			
		}
		
	}
}
