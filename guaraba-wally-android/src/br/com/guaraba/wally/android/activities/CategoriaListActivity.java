package br.com.guaraba.wally.android.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.guaraba.wally.android.domain.model.Categoria;
import br.com.guaraba.wally.android.domain.repositorios.RepositorioDeAnuncios;
import br.com.guaraba.wally.android.util.NumberUtils;
import br.com.guaraba.wally.android.util.StringUtils;

public class CategoriaListActivity extends ListActivity {

	public static final String PRODUTO = "AnuncioListActivity_PRODUTO";
	public static final String VALOR_ATE = "AnuncioListActivity_VALOR_DE";

	private String nomeDoProduto;
	private Double valorAte = 0d;
	private List<Categoria> todasCategorias;
	private Categoria categoria;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);

    	this.init();

		this.todasCategorias = new RepositorioDeAnuncios().listarCategoriasPorNomeDoProdutoEValor(this.nomeDoProduto, this.valorAte);

		List<String> categorias = new ArrayList<String>();
		if(this.todasCategorias != null && this.todasCategorias.size() > 0) {

			for (final Categoria categoria : this.todasCategorias) {

				categorias.add(categoria.getNome());
			}
		}

		this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categorias.toArray(new String[categorias.size()])));;
	}

	private void init() {

    	final Intent intent = this.getIntent();
    	if(intent != null) {

    		this.nomeDoProduto = intent.getStringExtra(PRODUTO);

    		final String valorAte = intent.getStringExtra(VALOR_ATE);
    		if(!StringUtils.isNullOrEmpty(valorAte) && NumberUtils.isNumeric(valorAte)) {

    			this.valorAte = NumberUtils.getDouble(valorAte);
    		}
    	}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);

		final String nomeDaCategoria = (String) this.getListAdapter().getItem(position);

		this.categoria = this.getCategoriaPorNome(nomeDaCategoria);

		final Bundle bundle = new Bundle();
		bundle.putSerializable(AnuncioListActivity.CATEGORIA, this.categoria);
		bundle.putString(AnuncioListActivity.PRODUTO, this.nomeDoProduto);

		if(this.valorAte != null && this.valorAte > 0) {

			bundle.putString(AnuncioListActivity.VALOR_ATE, this.valorAte.toString());
		}

		this.startActivity(new Intent(this, AnuncioListActivity.class).putExtras(bundle));
	}

	private Categoria getCategoriaPorNome(final String nome) {

		Categoria categoriaEncontrada = null;

		for (final Categoria categoria : this.todasCategorias) {

			if(categoria.getNome().equalsIgnoreCase(nome)) {

				categoriaEncontrada = categoria;
				break;
			}
		}

		return categoriaEncontrada;
	}
}