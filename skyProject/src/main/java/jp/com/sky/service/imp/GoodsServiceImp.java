package jp.com.sky.service.imp;

import org.springframework.stereotype.Service;

import jp.com.sky.constant.Constant;
import jp.com.sky.service.GoodsService;

@Service
public class GoodsServiceImp implements GoodsService {

	@Override

	public String getHeaderName(String kind) {

		String headerName = null;

		switch (Integer.parseInt(kind)) {

		case 1:
			headerName = Constant.OUTER;
			break;

		case 2:
			headerName = Constant.JACKET;
			break;

		case 3:
			headerName = Constant.TOPS;
			break;

		case 4:
			headerName = Constant.TSHUTS;
			break;

		case 5:
			headerName = Constant.KNIT;
			break;

		case 6:
			headerName = Constant.PANTS;
			break;

		case 7:
			headerName = Constant.JEANS;
			break;

		case 8:
			headerName = Constant.ROOMWEAR;
			break;

		case 9:
			headerName = Constant.UNDERWEAR;
			break;

		case 10:
			headerName = Constant.SHOES;
			break;

		case 11:
			headerName = Constant.GOODS;
			break;

		case 12:
			headerName = Constant.ACTIVE;
			break;

		default:
			break;
		}

		return headerName;
	}

//	@Override
//	public String getItemsinfor(String Detail) {
//	String itemsInfor = null;
//		return null;
//	}

}
