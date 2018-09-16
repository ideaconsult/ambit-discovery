/*
Copyright (C) 2005-2006  

Contact: nina@acad.bg

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public License
as published by the Free Software Foundation; either version 2.1
of the License, or (at your option) any later version.
All we ask is that proper credit is given for our work, which includes
- but is not limited to - adding the above copyright notice to the beginning
of your source code files, and to any copyright notice that you may distribute
with programs based on this work.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA
*/

package ambit2.similarity;

import org.openscience.cdk.qsar.model.QSARModelException;

public abstract class AbstractAttributeSelection<T> extends Object implements
		IAttributeSelection<T> {
	protected boolean evaluated = false;
	/**
	 * Transforms attributes stored in NearestNeighborsSearch, leaving only selected ones.
	 * @param nn
	 * @throws QSARModelException
	 */
	public void transformAttributes(NearestNeighborsSearch<T> nn) throws QSARModelException {
		if (evaluated)
			for (int i=0; i < nn.size();i++) {
				DistanceComparable<T> d = nn.get(i);
				d.setObject(transformToSelected(d.getObject()));
			}

	}
	public boolean isEvaluated() {
		return evaluated;
	}
	public void setEvaluated(boolean evaluated) {
		this.evaluated = evaluated;
	}


}


