import java.util.Arrays;
import java.util.Comparator;

/**
 * @author snaolekar
 * author : satyam naolekar
 * example use of comparator in java
 *
 */
public class useComparater {

	/**
	 * @param args
	 */
	static String[][] superPowerArray = {{"Power augmentation", "Ability to enhance or weaken the powers of others"}, 
		{"Power bestowal", "Ability to bestow powers or jump-start latent powers"}, 
		{"Power mimicry or absorption", "Ability to copy or absorb another''s powers or skills"},
		{"Power negation", "Ability to cancel the superpowers of others"}, 
		{"Power sensing", "Ability to sense or recognize superhuman powers"}, 
		{"Healing factor", "Ability to heal rapidly and with greater finality from any injury"},
		{"Acid generation", "Ability to generate acid, can be manifested through touch or as a spray"}, 
		{"Animal mimicry", "Ability to take on the abilities of certain animals"}, 
		{"Biological manipulation", "Ability to control all aspects of a living creature''s biological make-up"},
		{"Body part substitution", "Ability to replace one''s limbs or other body parts with those of another"}, 
		{"Bone manipulation", "Ability to manipulate the bones in one''s own body"}, 
		{"Duplication (physical)", "Ability to create physical duplicates of oneself"},
		{"Duplication (temporal)", "Ability to bring past and future versions of oneself back to the present"},
		{"Echolocation", "Ability to determine location of objects in the environment by use of reflected sound waves"},
		{"Firebreathing", "Ability generate gases from the body and exhale fire from the mouth"},
		{"Invisibility", "Ability to render the user unseen to the naked eye"},
		{"Invulnerability", "Ability to be immune to one or more forms of physical, mental, and spiritual damage and influence"},
		{"Kinetic absorption", "Ability to absorb forms of kinetic energy into oneself and utilize it in some way, such as by converting it into physical strength or using it to power energy blasts"},
		{"Superhuman longevity", "Ability to live longer than a normal human"},
		{"Matter Ingestion", "Ability to consume any sort of matter without any ill effects on the user"},
		{"Merging", "Ability to temporarily merge two or more beings into a single being, which results in a completely new and stronger being"},
		{"Pheromone manipulation", "Ability to generate and control pheromones which may have various effects"},
		{"Poison generation", "Ability to assault others with one or more varieties of toxins, with widely disparate effects"},
		{"Prehensile / animated hair", "Ability to animate and lengthen one''s hair"},
		{"Reactive adaptation / evolution", "Ability to develop a resistance or immunity to whatever they were injured by or exposed to"},
		{"Self-detonation / reformation", "Ability to explode one''s body mass and reform"},
		{"Sonic scream", "Ability to generate vocal sounds of a higher amplitude than a normal human"},
		{"Vortex breath", "Ability to inhale/exhale with superhumanly powerful strength"},
		{"Superhuman endurance", "Ability to have a higher resistance to one or more forms of damage before being injured as well as the ability to exert ones self in an activity indefinitely without becoming tired"},
		{"Superhuman agility", "Ability to react faster than a normal human and to possess greater flexibility and with higher/farther jumping capacity"},
		{"Superhuman senses", "Ability to see, smell, taste, feel and/or hear more than a normal Human"},
		{"Superhuman strength", "Ability to have a level of strength much higher than normally possible given their proportions"},
		{"Night vision", "The ability to see clearly in total darkness"},
		{"X-ray vision", "Ability to see through solid matter"},
		{"Heat vision", "Ability to burn objects and other individuals with one''s gaze"},
		{"Telescopic vision", "Ability to magnify and extend one''s vision to various levels"},
		{"Freeze vision", "Ability to freeze objects and other individuals with one''s gaze"},
		{"Wallcrawling", "Ability to adhere to solid surfaces, including walls and ceilings"},
		{"Waterbreathing", "Ability to respirate through water in lieu of a gaseous medium"},
		{"Ecological empathy", "The ability to sense the overall well-being and conditions of one''s immediate environment and natural setting stemming from a psychic sensitivity to nature"},
		{"Innate capability", "Ability to naturally have skills and/or knowledge typically earned through learning"},
		{"Omni-linguism", "Ability to understand any form of language"},
		{"Omniscience", "Ability to know anything and everything"},
		{"Superhuman mentality", "Ability to have intelligence quotient far above that of a genius level"},
		{"Superhuman tracking", "Ability to track an individual or object through supernatural means"},
		{"Astral projection", "This is the ability to separate and control one''s astral body"},
		{"Cross-dimensional awareness", "Ability to detect actions and events in other dimensions"},
		{"Empathy", "Ability to read or sense the emotions and/or control the emotions or feelings of others"},
		{"Mediumship", "Ability to see and communicate with the dead"},
		{"Precognition", "Ability to perceive the future"},
		{"Psychometry", "Ability to relate details about the past or future condition of an object or location"},
		{"Telepathy", "Ability to read the thoughts of, or to mentally communicate with others"},
		{"Technopathy", "Electrical/telekinetic manipulation that allows for a mental interface to manipulate technology"},
		{"Astral trapping", "Ability to cause an astral projection to stay on the astral plane"},
		{"Memory manipulation", "Ability to erase or enhance the memories of another"},
		{"Mind control", "The ability to alter the perceptions of others, and general ability to control the actions of others with the mind"},
		{"Possession", "Ability to take control and inhabit the body of an individual"},
		{"Psionic blast", "Ability to overload another''s mind causing pain, memory loss, lack of consciousness, vegetative state or death"},
		{"Psychic weapons", "Ability to create a weapon of psychic energy that can harm mentally and not physically"},
		{"Animation", "Ability to bring inanimate objects to life or to free an individual from petrification"},
		{"Darkness or shadow manipulation", "Ability to create or manipulate darkness"},
		{"Density control", "Ability to increase or decrease the natural density of an object and/or one''s self"},
		{"Disintegration", "Ability to disintegrate matter through touch or through beams"},
		{"Elemental transmutation", "The ability to alter chemical elements, changing them from one substance to another by rearranging the atomic structure"},
		{"Gravity manipulation", "Ability to manipulate or generate gravitons"},
		{"Immortality", "Ability to live forever. This may be complete immortality encompassing invulnerability, partial invulnerability to all but specific events "},
		{"Intangibility or phasing", "Ability to quantum tunnel through solid matter without harm"},
		{"Light manipulation", "Ability to control, generate or absorb light particles"},
		{"Magnetism manipulation", "Ability to control and/or generate magnetic fields"},
		{"Mass manipulation", "Ability to increase or decrease mass in an object"},
		{"Microwave manipulation", "The ability to convert ambient electromagnetic energy into microwaves and manipulate it into various effects such as heat, light, and radiation"},
		{"Molecular manipulation", "Ability to mentally manipulate the molecules of objects and/or one''s self on a molecular level"},
		{"Probability manipulation", "Ability to alter probability, causing unlikely things to happen, or likely things not to happen"},
		{"Radiation manipulation", "Ability to generate, manipulate or have immunity to toxic radiation"},
		{"Reality warping", "Ability to change or manipulate reality itself"},
		{"Resurrection", "Ability to come back to life after being killed as well as to bring others back to life"},
		{"Sound manipulation", "Ability to manipulate sound"},
		{"Time manipulation", "Ability to affect the flow of time by slowing, accelerating, reversing, or stopping it"},
		{"Air and wind manipulation", "Ability to control, generate, or absorb air or wind"},
		{"Animal control", "Ability to communicate with animals, birds and even aquatic creatures and get them to perform tasks on command"},
		{"Cold and ice manipulation", "Ability to reduce the kinetic energy of atoms and thus reduce temperature, can be used to control, generate, or absorb ice"},
		{"Earth manipulation", "Ability to control earth; sand, stone, rock, lava, dirt, or other minerals"},
		{"Electric manipulation", "Ability to control, generate or absorb electric fields"},
		{"Fire and heat manipulation", "Ability to control the kinetic energy of atoms to generate, control or absorb fire"},
		{"Plant manipulation", "Ability to create, control, manipulate or animate plant life"},
		{"Water and moisture manipulation", "Ability to control, generate or absorb water"},
		{"Weather manipulation", "Ability to control or mentally affect the weather"},
		{"Concussion beams", "Ability to generate or transform various forms of energy into a solid or concussive beam of energy"},
		{"Energy blasts", "Ability to expel various forms of energy from the body"},
		{"Energy constructs", "Ability to create complex shapes such as giant boxing gloves or cages or even functional machinery such as fire extinguishers or laser rifles out of solid energy"},
		{"Energy conversion", "Ability to absorb one form of energy and convert it into another form of energy"},
		{"Force field generation", "Ability to project powerful fields of manipulated energy"},
		{"Electrical transportation", "Ability to travel through electrical conduits such as power lines or telephone lines"},
		{"Omnipresence", "Ability to be present anywhere and everywhere simultaneously"},
		{"Dimensional travel", "Ability to travel between two or more dimensions, realities, realms"},
		{"Portal creation", "Ability to create wormholes, portation discs or other spatial portals for transport"},
		{"Summoning", "Ability to summon beings or objects for assistance"},
		{"Superhuman speed", "The ability to move, run, fly, react, think, and sense at speeds much faster than a normal human"},
		{"Teleportation", "Ability to move from one place to another without occupying the space in between"},
		{"Time travel", "Ability to travel back or forth through time"},
		{"Flight", "Ability to fly"},
		{"Animal morphing", "Ability to take on animal forms"},
		{"Elasticity", "Ability to stretch, deform, expand or contract one''s body into any form imaginable"},
		{"Inorganic", "Ability to transform completely into an inorganic substance while retaining organic properties"},
		{"Liquification", "Ability to turn partially or completely into a liquid"},
		{"Size shifting", "Ability to increase or decrease one''s size"},
		{"Sublimation", "Ability to transform into a gaseous, mist, or fog-like form"},
		{"Substance mimicry", "Ability to transform into any substance touched"}};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays.sort(superPowerArray, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {	
				return o1[0].compareToIgnoreCase(o2[0]);
			}
		});
    for(String[] item: superPowerArray){
    	System.out.println(item[0]+":"+item[1]);
    }
	}

}
