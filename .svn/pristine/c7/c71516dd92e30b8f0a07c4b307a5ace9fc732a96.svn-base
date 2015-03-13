package br.com.guaraba.wally.android.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.guaraba.wally.android.domain.model.Anuncio;
import br.com.guaraba.wally.android.domain.model.Categoria;
import br.com.guaraba.wally.android.domain.repositorios.RepositorioDeAnuncios;
import br.com.guaraba.wally.android.util.NumberUtils;
import br.com.guaraba.wally.android.util.StringUtils;

public class AnuncioListActivity extends ListActivity {

	public static final String PRODUTO = "AnuncioListActivity_PRODUTO";
	public static final String VALOR_ATE = "AnuncioListActivity_VALOR_ATE";
	public static final String CATEGORIA = "AnuncioListActivity_CATEGORIA";

	private Categoria categoria;
	private String nomeDoProduto;
	private Double valorAte;

	private List<Anuncio> todosAnuncios;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);

    	this.init();

    	final String[] anuncios = this.carregarAnuncios();

        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, anuncios)); 
	}

	private String[] carregarAnuncios() {

		final List<String> anuncios = new ArrayList<String>();

		this.todosAnuncios = new RepositorioDeAnuncios().listarAnunciosPorCategoriaNomeDoProdutoEValor(this.categoria, this.nomeDoProduto, this.valorAte);

		if(this.todosAnuncios != null && this.todosAnuncios.size() > 0) {

			for (int i = 0; i < this.todosAnuncios.size(); i++ ) {

				final Anuncio anuncio = this.todosAnuncios.get(i);

				anuncios.add(anuncio.getId().toString().concat(" - ")
						.concat(anuncio.getProduto().getNome()).concat(" ").concat(anuncio.getValorFormatado()));
			}
		}

		return anuncios.toArray(new String[anuncios.size()]);
	}

	private void init() {

    	final Intent intent = this.getIntent();
    	if(intent != null) {

    		this.nomeDoProduto = intent.getStringExtra(PRODUTO);

    		final String valorAte = intent.getStringExtra(VALOR_ATE);
    		if(!StringUtils.isNullOrEmpty(valorAte) && NumberUtils.isNumeric(valorAte)) {

    			this.valorAte = NumberUtils.getDouble(valorAte);
    		}

    		final Object categoria = intent.getSerializableExtra(CATEGORIA);
    		if(categoria != null) {

    			this.categoria = (Categoria) categoria;
    		}
    	}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);

		String anuncioIdString = (String) this.getListAdapter().getItem(position);
		anuncioIdString = anuncioIdString.substring(0, anuncioIdString.indexOf(" -"));

		if(NumberUtils.isNumeric(anuncioIdString)) {

			final Integer anuncioId = NumberUtils.getInteger(anuncioIdString);

			final Anuncio anuncio = this.getAnuncioPorId(anuncioId);

			final Bundle bundle = new Bundle();
			bundle.putSerializable(AnuncioActivity.ANUNCIO, anuncio);

			this.startActivity(new Intent(this, AnuncioActivity.class).putExtras(bundle));
		}
	}

	private Anuncio getAnuncioPorId(final Integer id) {

		Anuncio anuncioEncontrado = null;

		for (final Anuncio anuncio : this.todosAnuncios) {

			if(anuncio.getId().equals(id)) {

				anuncioEncontrado = anuncio;
				break;
			}
		}

		return anuncioEncontrado;
	}
}