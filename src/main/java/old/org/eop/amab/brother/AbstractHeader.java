package old.org.eop.amab.brother;

import java.util.ArrayList;
import java.util.List;

import old.org.eop.amab.Brother;
import old.org.eop.amab.Header;
import old.org.eop.amab.Tailer;

/**
 * @author lixinjie
 */
public abstract class AbstractHeader extends AbstractBrother implements Header {

	protected List<Brother> children;
	protected Tailer tailer;
	
	public AbstractHeader(String origin) {
		this(null, origin);
	}
	
	public AbstractHeader(Brother parent, String origin) {
		super(parent, origin);
		this.children = new ArrayList<>();
	}

	@Override
	public List<Brother> getChildren() {
		return children;
	}
	
	@Override
	public Brother addChild(Brother child) {
		child.setParent(this);
		children.add(child);
		return child;
	}

	@Override
	public Tailer getTailer() {
		return tailer;
	}
	
	@Override
	public void setTailer(Tailer tailer) {
		this.tailer = tailer;
	}
}
