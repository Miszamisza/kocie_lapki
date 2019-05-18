import React from 'react';

import {DataSearch, ReactiveBase, ReactiveList, ResultCard, SelectedFilters,} from '@appbaseio/reactivesearch';

import './Main.css';

const Main = () => (
    <ReactiveBase app="kitten-paws" credentials="hElAonkkR:136a18e0-ea9d-4190-b7a8-eec701e2bddb">
        <div className="row">
            <div className="col">


                <DataSearch
                    title="Cat Search"
                    dataField={['name']}
                    componentId="breeds"
                    URLParams
                    autosuggest={true}

                />

            </div>

            <div className="col">
                <SelectedFilters/>
                <ReactiveList
                    componentId="SearchResult"
                    dataField="original_title"
                    size={10}
                    className="result-list-container"
                    pagination
                    react={{
                        and: 'breeds',
                    }}
                    render={({data}) => (
                        <ReactiveList.ResultCardsWrapper>

                            {data.map(item =>
                                (

                                    <ResultCard key={item.id}>

                                        <ResultCard.Title>
                                            <div

                                                className="book-title"
                                                dangerouslySetInnerHTML={{
                                                    __html: item.name,
                                                }}
                                            />
                                        </ResultCard.Title>

                                        <ResultCard.Description>
                                            <div className="flex column justify-space-between">

                                            </div>
                                        </ResultCard.Description>
                                    </ResultCard>
                                ))}
                        </ReactiveList.ResultCardsWrapper>
                    )}
                />
            </div>
        </div>
    </ReactiveBase>
);

export default Main;