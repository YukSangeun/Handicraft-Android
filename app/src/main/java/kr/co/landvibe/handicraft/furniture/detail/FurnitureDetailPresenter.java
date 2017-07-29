package kr.co.landvibe.handicraft.furniture.detail;


import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import kr.co.landvibe.handicraft.data.domain.Furniture;
import kr.co.landvibe.handicraft.data.source.furniture.remote.FurnitureRemoteDataSource;
import kr.co.landvibe.handicraft.utils.LogUtils;
import retrofit2.HttpException;

public class FurnitureDetailPresenter implements FurnitureDetailContract.Presenter {

    private FurnitureDetailContract.View view;

    private FurnitureRemoteDataSource mFurnitureRemoteDataSource;

    private CompositeDisposable disposables;

    @Override
    public void attachView(FurnitureDetailContract.View view) {
        this.view = view;
        mFurnitureRemoteDataSource = FurnitureRemoteDataSource.getInstance();
        disposables = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        this.view = null;
        mFurnitureRemoteDataSource.destroyInstance();
        mFurnitureRemoteDataSource = null;
        disposables.dispose();
    }

    @Override
    public void loadFurniture(long id) {
        view.showLoading();
        disposables.add(
                mFurnitureRemoteDataSource.getFurniture(id)
                .subscribeWith(new DisposableSingleObserver<Furniture>() {
                    @Override
                    public void onSuccess(@NonNull Furniture furniture) {
                        view.bindData(furniture);
                        view.hideLoading();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if(e instanceof HttpException){
                            LogUtils.i(e.getMessage());
                            int code = ((HttpException) e).code();
                            switch (code){
                                case 400:
                                    break;
                                case 401:
                                    break;
                                case 403:
                                    break;
                                case 500:
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            LogUtils.e(e.getMessage());
                        }
                    }
                })
        );
    }
}
