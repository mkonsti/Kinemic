
public class Parameters {

private boolean active;
private String flags;
private int last;
private String sensor;
private String stream;

private String name;

private String vocabulary;
private String hypothesis;
private boolean Final;

public Parameters(boolean active, String flags, int last, String sensor, String stream){
	this.active=active;
	this.flags=flags;
	this.last=last;
	this.sensor=sensor;
	this.stream=stream;
	this.name="noGesture";
}

public Parameters(String name){
	this.name=name;
}

public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
public String getFlags() {
	return flags;
}
public void setFlags(String flags) {
	this.flags = flags;
}
public int getLast() {
	return last;
}
public void setLast(int last) {
	this.last = last;
}
public String getSensor() {
	return sensor;
}
public void setSensor(String sensor) {
	this.sensor = sensor;
}
public String getStream() {
	return stream;
}
public void setStream(String stream) {
	this.stream = stream;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getVocabulary() {
	return vocabulary;
}

public void setVocabulary(String vocabulary) {
	this.vocabulary = vocabulary;
}

public String getHypothesis() {
	return hypothesis;
}

public void setHypothesis(String hypothesis) {
	this.hypothesis = hypothesis;
}

public boolean isFinal() {
	return Final;
}

public void setFinal(boolean final1) {
	Final = final1;
}


}
