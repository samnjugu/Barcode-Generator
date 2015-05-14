package com.muthii.to;

import java.util.ArrayList;
import java.util.List;

public class BarcodesTO {
	private List<BarcodeTO> codes = new ArrayList<BarcodeTO>();

	public List<BarcodeTO> getCodes() {
		return codes;
	}

	public void setCodes(List<BarcodeTO> codes) {
		this.codes = codes;
	}

}
