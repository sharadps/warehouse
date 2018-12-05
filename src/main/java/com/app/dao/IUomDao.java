package com.app.dao;

import java.util.List;

import com.app.model.Uom;

public interface IUomDao {

	public Integer saveUom(Uom uom);

	public void updateUom(Uom uom);

	public void deleteUom(Integer uomId);

	public Uom getOneUom(Integer uomId);

	public List<Uom> getAllUom();

	public boolean isUomModelExist(String uomModel);

	public boolean isUomConnectedWithItem(Integer id);
}
